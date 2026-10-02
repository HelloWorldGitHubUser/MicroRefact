package com.central.lock;
 import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class ZLock implements AutoCloseable{

@Getter
 private  Object lock;

 private  KeyedLock locker;


@Override
public void close() throws Exception{
    locker.unlock(lock);
}


}