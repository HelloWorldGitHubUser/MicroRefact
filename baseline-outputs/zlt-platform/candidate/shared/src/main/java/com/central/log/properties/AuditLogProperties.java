package com.central.log.properties;
 import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "zlt.audit-log")
public class AuditLogProperties {

 private  Boolean enabled;


}