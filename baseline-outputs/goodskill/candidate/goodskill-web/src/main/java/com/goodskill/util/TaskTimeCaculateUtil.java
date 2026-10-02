package com.goodskill.util;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.util.StopWatch;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Slf4j
public class TaskTimeCaculateUtil {

 private  StopWatch stopWatch;

 private  Map<String,StopWatch> taskWatchMap;


public void startTask(String taskName,String taskId){
    if (stopWatch.getTaskCount() > 10 || stopWatch.isRunning()) {
        stopWatch = new StopWatch();
    }
    try {
        stopWatch.start(taskName);
        taskWatchMap.put(taskId, stopWatch);
    } catch (IllegalStateException e) {
        log.warn("Last task have not finish yet!", e);
    }
}


public String prettyPrint(String taskId){
    if (!StringUtils.hasText(taskId)) {
        return null;
    }
    StopWatch taskStopWatch = taskWatchMap.get(taskId);
    if (taskStopWatch == null) {
        return null;
    }
    return taskStopWatch.prettyPrint();
}


public void stop(String taskId){
    try {
        taskWatchMap.get(taskId).stop();
    } catch (IllegalStateException e) {
        log.warn("Oops, stop error occurs!", e);
    }
}


}