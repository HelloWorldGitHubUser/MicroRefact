package com.central.config;
 import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.central.datascope.DataScopeInnerInterceptor;
import com.central.datascope.DataScopeProperties;
import com.central.datascope.SqlHandler;
import jakarta.annotation.Resource;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;
@Configuration
@MapperScan("com.central.mapper")
public class MyBatisPlusConfig implements MetaObjectHandler{

@Resource
 private  DataScopeProperties dataScopeProperties;

@Resource
 private  SqlHandler sqlHandler;


@Override
public void updateFill(MetaObject metaObject){
    this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
}


@Override
public void insertFill(MetaObject metaObject){
    this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
}


@Bean
public MybatisPlusInterceptor mybatisPlusInterceptor(){
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 数据权限拦截器（必须在分页插件之前）
    if (dataScopeProperties.getEnabled()) {
        interceptor.addInnerInterceptor(new DataScopeInnerInterceptor(dataScopeProperties, sqlHandler));
    }
    // 分页插件
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    return interceptor;
}


}