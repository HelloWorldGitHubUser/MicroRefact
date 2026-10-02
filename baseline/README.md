# MicroRefact 基线：在 input-kit 应用上生成候选微服务代码

本目录用 MicroRefact（本仓库 `app/`）把 `baseline-inputs/` 下 10 个单体按给定的 decomposition
转换成微服务，产物在 `baseline-outputs/<app>/candidate/`，供后续编译检查使用。
不做任何编译、运行或打包；候选代码就是 MicroRefact 的原样输出。

## 运行

```bash
baseline/run_all.sh                 # 全部 10 个应用
baseline/run_all.sh booking zlt-platform   # 指定应用
```

需要 JDK 11+（只用于运行解析器）、Maven、Python 3。首次运行会构建 `app/javaParser`
（jar 约 500MB，已在 `.gitignore` 中）。每个应用的配置在 `apps.tsv`。

每个应用的流程：

1. 运行 MicroRefact 的 Java 解析器，得到它能识别的类型（`app/javaParser/output.json`）；
2. `convert.py` 把 decomposition 转成 MicroRefact 的 proposal 格式；
3. `run_seeded.py` 以固定随机种子运行未改动逻辑的 `app/main.py`（`database.py` 生成外键列名时用了
   `random`，固定种子后两次运行产物逐字节相同）；
4. 把 `app/Results/ik__<app>/<序号>/` 移到 `baseline-outputs/<app>/candidate/<服务名>/`。

## 产物结构

```
baseline-outputs/<app>/
  candidate/<service>/pom.xml          MicroRefact 复制的单体根 pom.xml
  candidate/<service>/src/main/java/   MicroRefact 生成的 Java 源码
  run/proposal.json                    交给 MicroRefact 的划分方案
  run/proposal.json.meta.json          序号→服务名、被丢弃的类型、移入 shared 的类及原因
  run/result.json                      退出码、耗时、服务列表、Java 文件数、编译用 JDK
  run/stats.csv                        MicroRefact 自己的统计：实体数, 跨服务实体关系数, 跨服务类依赖数
  run/domain.puml                      MicroRefact 输出的服务/类图
  run/{parse,microrefact}.log.gz, run/convert.log
```

目录名由序号改成了服务名，其余内容未做任何修改。MicroRefact 若为跨服务多对多关系额外创建服务，
该目录保留它自己起的名字（本批 10 个应用中没有出现）。

## 对 MicroRefact 的改动（仅为能在这些输入上运行）

| 补丁 | 位置 | 原因 |
|---|---|---|
| P0 | `app/main.py` | 统计 CSV 写死为作者本机路径 `/home/fracisco/...`，其他机器上在最后一步报错退出；改为 `MR_STATS_CSV`，默认当前目录 |
| P1 | `app/main.py` | 只有 1 个类的簇会因 `clusterClasses[1]` 越界而崩溃（petclinic `api-gateway`、passjava `passjava-thirdparty`）；只有一个类时用它自己 |
| P3 | `app/javaParser/.../Parser.java` | JavaParser 默认按 Java 8 语法解析，ecommerce 的 `case X ->` 写法会导致解析器崩溃；改为读环境变量 `MR_LANG_LEVEL`，默认仍是 `JAVA_8`。Java 17/21 应用用 `JAVA_14`（此 JavaParser 版本的上限） |

生成逻辑未做任何修改，生成代码中的缺陷（缺 import、丢 `static`、类的泛型参数丢失、
多余的 `}`、`List<X>.class` 等）均原样保留。

## decomposition → proposal 规则

MicroRefact 要求每个类恰好属于一个簇，且解析器看到的每个类都必须在某个簇里；它没有“共享库”
概念，每个簇都会成为一个服务（带 `Main.java`，被其他簇通过 REST 调用）。因此：

- `""` 之前且只被一个服务列出的类 → 该服务；
- 顶层 `shared` 中的类、被多个服务在 `""` 前列出的类、只出现在 `""` 之后的类 → `shared` 簇；
- 未被列出的内部类 → 跟随其外部类；
- 解析器看到但 decomposition 未列出的类（启动类、配置类等）→ `shared` 簇；
- 解析器不输出的类型（enum、record、注解类型，以及 5 个使用了 Java 15+ 语法、如 `instanceof` 模式匹配或内嵌 record、而解析失败的普通类）→ 从 proposal 中移除
  并记录在 meta 文件中（否则 MicroRefact 会 `KeyError` 崩溃）。这些类型不会出现在候选代码中。

## 结果（输入 `b3e80d2`）

10 个应用全部运行完成（退出码 0）。

| app | 服务数 | Java 文件 | 被丢弃的类型 | 多服务共有→shared | 未列出→shared | MicroRefact 统计（实体/跨服务关系/跨服务依赖） | 编译 JDK |
|---|---|---|---|---|---|---|---|
| booking | 4 | 183 | 45 record, 4 enum, 2 class | 0 | 14 | 6/0/0 | 17 |
| ecommerce | 14 | 287 | 26 record, 7 enum, 2 @interface, 2 class | 0 | 15 | 21/0/22 | 17 |
| goodskill | 7 | 164 | 7 enum | 0 | 8 | 0/0/15 | 21 |
| gulimall | 11 | 476 | 3 enum, 2 @interface | 4 | 4 | 0/0/466 | 8 |
| lakeside-mutual | 5 | 209 | 2 enum, 1 @interface | 3 | 1 | 21/0/116 | 17 |
| newbee-mall | 6 | 150 | 6 enum, 2 @interface | 2 | 4 | 0/0/30 | 8 |
| passjava | 8 | 95 | 1 enum | 0* | 7 | 0/0/100 | 8 |
| spring-petclinic | 5 | 89 | 0 | 0 | 6 | 6/2/27 | 8 |
| youlai-mall | 7 | 403 | 16 enum, 1 @interface, 1 class | 0 | 25 | 0/0/138 | 17 |
| zlt-platform | 6 | 142 | 3 enum | 0 | 32 | 0/0/44 | 17 |

\* passjava 的 8 个多服务共有类同时在顶层 `shared` 中，按“在 shared 列表中”计。
gulimall、newbee-mall 各有部分多服务共有的类型是注解类型，已被丢弃，因此少于 decomposition 中的数量。

编译前须知：

- 每个服务的 `pom.xml` 是单体根 pom 的副本。booking 和 spring-petclinic 的根 pom 是聚合 pom
  （`<packaging>pom</packaging>`，`<modules>` 指向不存在的子模块），这是 MicroRefact 的原样行为。
- 候选代码不含任何资源文件（`application.properties`、mapper XML、静态资源等）。
- 6 个 MyBatis 应用（goodskill、gulimall、newbee-mall、passjava、youlai-mall、zlt-platform）没有
  `@Entity`，MicroRefact 的数据库重构阶段不会触发，只做类划分和跨服务调用的 REST 代理生成。

## 编译检查

```bash
baseline/compile_all.sh [app ...]     # 需要 /usr/lib/jvm/java-{8,17,21}-openjdk-amd64
```

对每个应用，先编译原单体作为对照，再对每个候选服务目录原样执行 `mvn compile`，使用该应用自己的 JDK
（`apps.tsv` 第 4 列）。所有构建使用同一组开关，只跳过需要 git 仓库或前端工具链的插件
（`-Dmaven.gitcommitid.skip=true -Dskip.npm ...`），不影响 Java 编译。构建在仓库外的副本上进行。
结果在 `baseline-outputs/<app>/compile/`：`summary.tsv`（状态、javac 错误数、第一条错误）和各模块的 Maven 日志。
`summarize_compile.py` 可从日志重新生成汇总。

| app | 单体（对照） | 候选服务通过 | 失败阶段 | 各服务 javac 错误数 |
|---|---|---|---|---|
| booking | 通过 | 0/4 | pom | - |
| ecommerce | 通过 | 0/14 | javac | 1–100 |
| goodskill | 通过 | 0/7 | javac | 2–89 |
| gulimall | 通过 | 0/11 | javac | 1–100 |
| lakeside-mutual | 通过 | 0/5 | javac | 2–65 |
| newbee-mall | 通过 | 0/6 | javac | 1–100 |
| passjava | 通过 | 0/8 | javac | 12–87 |
| spring-petclinic | 通过 | 0/5 | pom | - |
| youlai-mall | 通过 | 0/7 | javac | 6–16 |
| zlt-platform | 通过 | 0/6 | javac | 4–91 |

10 个单体全部编译通过；73 个候选服务全部失败：9 个卡在 pom（聚合 pom 的 `<modules>` 不存在），64 个是 javac 错误。
javac 错误数是下限：遇到语法错误后 javac 不再做类型检查，且每个模块最多报 100 个错误。

最常见的 javac 错误（所有候选服务合计）：

| 错误 | 次数 | 出现的服务数 |
|---|---|---|
| cannot find symbol | 956 | 27 |
| package … does not exist | 395 | 23 |
| `<identifier> expected`（如 `List<X>.class`） | 48 | 23 |
| `'.' expected`（如 `import lombok;`，原为 `import lombok.*;`） | 24 | 10 |
| non-static … cannot be referenced from a static context（`static` 丢失） | 37 | 10 |

## 服务间通信核对

```bash
python3 baseline/analyze_communication.py   # 写出 baseline-outputs/<app>/run/communication.json
```

MicroRefact 生成的通信只有一种：用 `RestTemplate` 发同步 HTTP 请求（`getForObject` 或 `put`），由被调服务里生成的
`NEW*/…Controller` 接收。脚本找出全部 181 处调用，按调用地址中的簇序号找到目标服务，再与目标服务中的
接口逐一比对（不考虑能否编译）：目标服务存在且不是自己；恰好有一个 HTTP 方法和路径都相同的接口；
查询参数名、路径变量个数、是否带请求体一致；两端都没有退化成 `Object` 类型，参数和返回类型一致。
对比对一致的调用，再检查不涉及编译、但运行时仍会失败的原因。

| app | 调用数 | 两端对得上 | 其中目标是原 static 方法 | 且服务端无运行时阻断 |
|---|---|---|---|---|
| booking | 0 | 0 | 0 | 0 |
| ecommerce | 9 | 5 | 0 | 0 |
| goodskill | 11 | 11 | 5 | 0 |
| gulimall | 35 | 32 | 14 | 0 |
| lakeside-mutual | 31 | 26 | 0 | 0 |
| newbee-mall | 14 | 10 | 0 | 0 |
| passjava | 18 | 18 | 10 | 0 |
| spring-petclinic | 27 | 19 | 0 | 0 |
| youlai-mall | 24 | 11 | 6 | 0 |
| zlt-platform | 12 | 11 | 6 | 0 |
| 合计 | 181 | 143 | 41 | 0 |

对不上的 38 处：16 处参数或返回类型退化为 `Object`（方法继承自 Spring Data 等外部类，MicroRefact 不知道签名），
19 处目标服务里有多个同路径接口（如两个 Repository 都暴露 `/findById`），9 处目标服务里根本没有对应接口，
10 处参数名不一致，7 处返回类型不一致（一处可同时有多个问题）。

对得上的 143 处运行时仍全部失败：138 处服务端 Controller 的字段没有 `@Autowired`（空指针）；54 处把对象
作为查询字符串参数发送（无法绑定回对象）；5 处落到 MicroRefact 新加、没有实现的 Repository 方法。
另外所有调用的地址都是 `http://<簇序号>`，不是可解析的服务地址。
