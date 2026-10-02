package com.central.log.service.impl;
 import com.central.log.model.Audit;
import com.central.log.service.IAuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;
@Slf4j
@Component
public class LoggerAuditServiceImpl implements IAuditService{

 private  String MSG_PATTERN;


@Async
@Override
public void save(Audit audit){
    log.debug(MSG_PATTERN, audit.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), audit.getApplicationName(), audit.getClassName(), audit.getMethodName(), audit.getUserId(), audit.getUserName(), audit.getClientId(), audit.getOperation());
}


}