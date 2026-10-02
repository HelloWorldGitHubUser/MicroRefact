package com.central.service.impl;
 import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.central.exception.IdempotencyException;
import com.central.exception.LockException;
import com.central.lock.KeyedLock;
import com.central.lock.ZLock;
import com.central.service.ISuperService;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public class SuperServiceImpl extends ServiceImpl<M, T>implements ISuperService<T>{


@Override
public boolean saveIdempotency(T entity,KeyedLock lock,String lockKey,Wrapper<T> countWrapper) throws Exception{
    return saveIdempotency(entity, lock, lockKey, countWrapper, null);
}


@Override
public boolean saveOrUpdateIdempotency(T entity,KeyedLock lock,String lockKey,Wrapper<T> countWrapper) throws Exception{
    return this.saveOrUpdateIdempotency(entity, lock, lockKey, countWrapper, null);
}


}