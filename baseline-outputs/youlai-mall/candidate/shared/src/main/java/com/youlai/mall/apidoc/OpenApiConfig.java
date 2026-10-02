package com.youlai.mall.apidoc;
 import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(ApiDocInfoProperties.class)
public class OpenApiConfig {

 private  String CONTROLLER_PACKAGE;

@Value("${spring.security.oauth2.authorizationserver.token-uri}")
 private  String tokenUrl;

 private  ApiDocInfoProperties apiDocInfoProperties;


@Bean
public GroupedOpenApi sysDictControllerApi(){
    return controllerApi("SysDictController", "/api/v1/dict");
}


@Bean
public GroupedOpenApi omsOrderControllerApi(){
    return controllerApi("OmsOrderController", "/api/v1/orders");
}


@Bean
public GroupedOpenApi skuControllerApi(){
    return controllerApi("SkuController", "/app-api/v1/skus");
}


@Bean
public GroupedOpenApi sysMenuControllerApi(){
    return controllerApi("SysMenuController", "/api/v1/menus");
}


@Bean
public GroupedOpenApi categoryControllerApi(){
    return controllerApi("CategoryController", "/app-api/v1/categories");
}


@Bean
public GroupedOpenApi pmsSkuControllerApi(){
    return controllerApi("PmsSkuController", "/api/v1/sku");
}


@Bean
public GroupedOpenApi cartControllerApi(){
    return controllerApi("CartController", "/app-api/v1/carts");
}


@Bean
public GroupedOpenApi spuControllerApi(){
    return controllerApi("SpuController", "/app-api/v1/spu");
}


@Bean
public GroupedOpenApi smsAdvertControllerApi(){
    return controllerApi("SmsAdvertController", "/api/v1/adverts");
}


@Bean
public GroupedOpenApi pmsCategoryControllerApi(){
    return controllerApi("PmsCategoryController", "/api/v1/categories");
}


public GroupedOpenApi controllerApi(String group,String pathPrefix){
    return GroupedOpenApi.builder().group(group).packagesToScan(CONTROLLER_PACKAGE).pathsToMatch(pathPrefix, pathPrefix + "/**").build();
}


@Bean
public GroupedOpenApi sysDeptControllerApi(){
    return controllerApi("SysDeptController", "/api/v1/dept");
}


@Bean
public GroupedOpenApi sysRoleControllerApi(){
    return controllerApi("SysRoleController", "/api/v1/roles");
}


@Bean
public GroupedOpenApi addressControllerApi(){
    return controllerApi("AddressController", "/app-api/v1/addresses");
}


@Bean
public GroupedOpenApi authControllerApi(){
    return controllerApi("AuthController", "/api/v1/auth");
}


@Bean
public GroupedOpenApi umsMemberControllerApi(){
    return controllerApi("UmsMemberController", "/api/v1/members");
}


@Bean
public GroupedOpenApi wxPayCallbackControllerApi(){
    return controllerApi("WxPayCallbackController", "/callback-api/v1/wx-pay");
}


@Bean
public GroupedOpenApi memberControllerApi(){
    return controllerApi("MemberController", "/app-api/v1/members");
}


@Bean
public GroupedOpenApi advertControllerApi(){
    return controllerApi("AdvertController", "/app-api/v1/adverts");
}


@Bean
public OpenAPI apiInfo(){
    return new OpenAPI().components(new Components().addSecuritySchemes(HttpHeaders.AUTHORIZATION, new SecurityScheme().type(SecurityScheme.Type.OAUTH2).name(HttpHeaders.AUTHORIZATION).flows(new OAuthFlows().password(new OAuthFlow().tokenUrl(tokenUrl).refreshUrl(tokenUrl))).in(SecurityScheme.In.HEADER).scheme("Bearer").bearerFormat("JWT"))).addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION)).info(new Info().title(apiDocInfoProperties.getTitle()).version(apiDocInfoProperties.getVersion()).description(apiDocInfoProperties.getDescription()).contact(new Contact().name(apiDocInfoProperties.getContact().getName()).url(apiDocInfoProperties.getContact().getUrl()).email(apiDocInfoProperties.getContact().getEmail())).license(new License().name(apiDocInfoProperties.getLicense().getName()).url(apiDocInfoProperties.getLicense().getUrl())));
}


@Bean
public GroupedOpenApi orderControllerApi(){
    return controllerApi("OrderController", "/app-api/v1/orders");
}


@Bean
public GroupedOpenApi pmsAttributeControllerApi(){
    return controllerApi("PmsAttributeController", "/api/v1/attributes");
}


@Bean
public GroupedOpenApi smsCouponControllerApi(){
    return controllerApi("SmsCouponController", "/api/v1/coupons");
}


@Bean
public GroupedOpenApi pmsBrandControllerApi(){
    return controllerApi("PmsBrandController", "/api/v1/brands");
}


@Bean
public GroupedOpenApi sysUserControllerApi(){
    return controllerApi("SysUserController", "/api/v1/users");
}


@Bean
public GroupedOpenApi pmsSpuControllerApi(){
    return controllerApi("PmsSpuController", "/api/v1/spu");
}


@Bean
public GroupedOpenApi fileControllerApi(){
    return controllerApi("FileController", "/api/v1/files");
}


}