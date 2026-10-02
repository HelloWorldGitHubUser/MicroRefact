package com.central.config;
 import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "zlt.security")
public class SecurityProperties {

 private  AuthProperties auth;

 private  IgnoreProperties ignore;

 private  UrlPermissionProperties urlPermission;

 private  Boolean enable;

 private  List<String> urls;


}