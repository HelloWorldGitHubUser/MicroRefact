package com.youlai.mall.factory;
 import cn.hutool.core.util.StrUtil;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
public class NamedThreadFactory implements ThreadFactory{

 private  AtomicInteger poolNumber;

 private  ThreadGroup threadGroup;

 private  AtomicInteger threadNumber;

 public  String namePrefix;

public NamedThreadFactory(String name) {
    this.threadGroup = Thread.currentThread().getThreadGroup();
    if (StrUtil.isBlank(name)) {
        name = "pool";
    }
    namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
}
@Override
public Thread newThread(Runnable r){
    Thread t = new Thread(threadGroup, r, namePrefix + threadNumber.getAndIncrement(), 0);
    if (t.isDaemon()) {
        t.setDaemon(false);
    }
    if (t.getPriority() != Thread.NORM_PRIORITY) {
        t.setPriority(Thread.NORM_PRIORITY);
    }
    return t;
}


}