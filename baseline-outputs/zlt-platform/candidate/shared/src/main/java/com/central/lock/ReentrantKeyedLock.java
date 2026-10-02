package com.central.lock;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
@Slf4j
@Component
public class ReentrantKeyedLock implements KeyedLock{

 private  ConcurrentHashMap<String,ReentrantLock> lockMap;

 private  String key;

 private  ReentrantLock lock;


public String getKey(){
    return key;
}


@Override
public void unlock(Object lock) throws Exception{
    if (lock == null) {
        return;
    }
    if (lock instanceof LockWrapper) {
        LockWrapper wrapper = (LockWrapper) lock;
        ReentrantLock reentrantLock = wrapper.getLock();
        if (reentrantLock.isHeldByCurrentThread()) {
            reentrantLock.unlock();
            log.debug("释放锁成功, key: {}", wrapper.getKey());
            // 如果没有线程持有该锁，从 map 中移除以避免内存泄漏
            if (!reentrantLock.isLocked()) {
                lockMap.remove(wrapper.getKey(), reentrantLock);
            }
        }
    }
}


public ReentrantLock getLock(){
    return lock;
}


@Override
public ZLock lock(String key,long leaseTime,TimeUnit unit,boolean isFair) throws Exception{
    ReentrantLock lock = lockMap.computeIfAbsent(key, k -> new ReentrantLock(isFair));
    lock.lock();
    log.debug("获取锁成功, key: {}", key);
    return new ZLock(new LockWrapper(key, lock), this);
}


@Override
public ZLock tryLock(String key,long waitTime,long leaseTime,TimeUnit unit,boolean isFair) throws Exception{
    ReentrantLock lock = lockMap.computeIfAbsent(key, k -> new ReentrantLock(isFair));
    boolean acquired;
    if (waitTime > 0 && unit != null) {
        acquired = lock.tryLock(waitTime, unit);
    } else {
        acquired = lock.tryLock();
    }
    if (acquired) {
        log.debug("尝试获取锁成功, key: {}", key);
        return new ZLock(new LockWrapper(key, lock), this);
    }
    log.debug("尝试获取锁失败, key: {}", key);
    return null;
}


}