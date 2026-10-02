package com.central.lock;
 import java.util.concurrent.TimeUnit;
public interface KeyedLock {


public void unlock(ZLock zLock) throws Exception{
    if (zLock != null) {
        this.unlock(zLock.getLock());
    }
}
;

public ZLock lock(String key) throws Exception{
    return this.lock(key, -1, null, false);
}
;

public ZLock tryLock(String key,long waitTime,TimeUnit unit) throws Exception{
    return this.tryLock(key, waitTime, -1, unit, false);
}
;

}