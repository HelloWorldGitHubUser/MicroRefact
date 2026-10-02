package com.central.exception;
 import com.central.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation;
import java.sql.SQLException;
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler({ SQLException.class })
public Result<?> handleSQLException(SQLException e){
    return defHandler("服务运行SQLException异常", e);
}


@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
public Result<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
    return defHandler("不支持当前请求方法", e);
}


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler(Exception.class)
public Result<?> handleException(Exception e){
    return defHandler("未知异常", e);
}


@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
@ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
public Result<?> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
    return defHandler("不支持当前媒体类型", e);
}


@ResponseStatus(HttpStatus.FORBIDDEN)
@ExceptionHandler({ AccessDeniedException.class })
public Result<?> badMethodExpressException(AccessDeniedException e){
    return defHandler("没有权限请求当前方法", e);
}


@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler({ IllegalArgumentException.class })
public Result<?> badRequestException(IllegalArgumentException e){
    return defHandler("参数解析失败", e);
}


public Result<?> defHandler(String msg,Exception e){
    log.error(msg, e);
    return Result.failed(msg);
}


}