# baseline-inputs

Inputs copied from `input-kit` commit `b3e80d2` ("release(input-kit): prepare agent-input-v8").
Only git-tracked files were copied. For each application:

- `monolith/`: the monolith source tree (renamed from the directory listed below)
- `decomposition.json`: the decomposition given to agents (`<app>.json` in input-kit)

Nothing else from input-kit (architecture spec, prepared components, micro_db, `*-m2m`)
is used: MicroRefact only reads Java sources, the root `pom.xml` and a microservice proposal.

| app | input-kit monolith | input-kit decomposition | path passed to MicroRefact | Java (pom) | JDK for compile check |
|---|---|---|---|---|---|
| booking | `booking/booking-monolith` | `booking/booking.json` | `monolith` | 17 | 17 |
| ecommerce | `ecommerce/ecommerce-monolith` | `ecommerce/ecommerce.json` | `monolith` | 17 | 17 |
| goodskill | `goodskill/goodsKill-monolith` | `goodskill/goodskill.json` | `monolith` | 21 | 21 |
| gulimall | `gulimall/gulimall-monolith` | `gulimall/gulimall.json` | `monolith` | 1.8 | 8 |
| lakeside-mutual | `lakeside-mutual/lakeside-mutual-monolith` | `lakeside-mutual/lakeside.json` | `monolith` | 17 | 17 |
| newbee-mall | `newbee-mall/newbee-mall-api` | `newbee-mall/newbee-mall.json` | `monolith` | 1.8 | 8 |
| passjava | `passjava/PassJava-Platform-monolith` | `passjava/PassJava-Platform.json` | `monolith/passjava-monolith` | 1.8 | 8 |
| spring-petclinic | `spring-petclinic/spring-petclinic-angularjs` | `spring-petclinic/spring-petclinic.json` | `monolith` | 1.8 (Spring Boot 2.1 default) | 8 |
| youlai-mall | `youlai-mall/youlai-mall-mono` | `youlai-mall/youlai-mall.json` | `monolith` | 17 | 17 |
| zlt-platform | `zlt-platform/zlt-platform-monolith` | `zlt-platform/zlt-platform.json` | `monolith` | 17 | 17 |

passjava's Maven project lives in the `passjava-monolith/` subdirectory (the top level only
holds `init-db/` and `scripts/`), so MicroRefact is pointed there, where its `pom.xml` is.

To refresh after input-kit changes, re-copy the same paths and update the commit above.
