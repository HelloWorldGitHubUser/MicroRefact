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
