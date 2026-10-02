package com.central.trace;
 import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "zlt.trace")
public class TraceProperties {

 private  Boolean enable;


}