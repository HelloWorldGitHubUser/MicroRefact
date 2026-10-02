package com.central.lock.ReentrantKeyedLock;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
public class LockWrapper {

 private  String key;

 private  ReentrantLock lock;

public LockWrapper(String key, ReentrantLock lock) {
    this.key = key;
    this.lock = lock;
}
public String getKey(){
    return key;
}


public ReentrantLock getLock(){
    return lock;
}


}