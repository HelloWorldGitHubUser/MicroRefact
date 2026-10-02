package com.central.datascope;
 import cn.hutool.core.collection.CollUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Data
@Component
@ConfigurationProperties(prefix = "zlt.datascope")
public class DataScopeProperties {

 private  Set<String> DEFAULT_IGNORE_SQL_ID;

 private  Boolean enabled;

 private  Boolean enabledSqlDebug;

 private  Set<String> ignoreTables;

 private  Set<String> ignoreSqls;

 private  Set<String> includeTables;

 private  Set<String> includeSqls;

 private  String creatorIdColumnName;


public void setIgnoreSqls(Set<String> ignoreSqls){
    Set<String> ignoreSet = new HashSet<>(DEFAULT_IGNORE_SQL_ID);
    if (CollUtil.isNotEmpty(ignoreSqls)) {
        ignoreSet.addAll(ignoreSqls);
    }
    this.ignoreSqls = ignoreSet;
}


}