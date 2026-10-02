package com.central.service;
 import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.central.lock.KeyedLock;
public interface ISuperService extends IService<T>{


public boolean saveIdempotency(T entity,KeyedLock locker,String lockKey,Wrapper<T> countWrapper) throws Exception
;

public boolean saveOrUpdateIdempotency(T entity,KeyedLock locker,String lockKey,Wrapper<T> countWrapper) throws Exception
;

}