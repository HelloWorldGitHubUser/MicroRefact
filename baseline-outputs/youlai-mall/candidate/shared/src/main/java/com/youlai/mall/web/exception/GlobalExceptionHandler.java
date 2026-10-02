package com.youlai.mall.web.exception;
 import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.youlai.mall.result.Result;
import com.youlai.mall.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import jakarta.servlet.ServletException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.concurrent.CompletionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(IllegalArgumentException.class)
public Result<T> handleIllegalArgumentException(IllegalArgumentException e){
    log.error("非法参数异常，异常原因：{}", e.getMessage(), e);
    return Result.failed(e.getMessage());
}


@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(Exception.class)
public Result<T> handleException(Exception e){
    log.error("unknown exception:{}", e.getMessage(), e);
    String errorMsg = e.getMessage();
    if (StrUtil.isNotBlank(errorMsg) && errorMsg.contains("denied to user")) {
        return Result.failed(ResultCode.FORBIDDEN_OPERATION);
    }
    if (StrUtil.isBlank(errorMsg)) {
        errorMsg = "系统异常";
    }
    return Result.failed(errorMsg);
}


@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(JsonProcessingException.class)
public Result<T> handleJsonProcessingException(JsonProcessingException e){
    log.error("Json转换异常，异常原因：{}", e.getMessage(), e);
    return Result.failed(e.getMessage());
}


@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(BizException.class)
public Result<T> handleBizException(BizException e){
    log.error("biz exception:{}", e.getMessage(), e);
    if (e.getResultCode() != null) {
        return Result.failed(e.getResultCode());
    }
    return Result.failed(e.getMessage());
}


@ResponseStatus(HttpStatus.FORBIDDEN)
@ExceptionHandler(SQLSyntaxErrorException.class)
public Result<T> processSQLSyntaxErrorException(SQLSyntaxErrorException e){
    String errorMsg = e.getMessage();
    log.error(errorMsg);
    if (StrUtil.isNotBlank(errorMsg) && errorMsg.contains("denied to user")) {
        return Result.failed(ResultCode.FORBIDDEN_OPERATION);
    } else {
        return Result.failed(e.getMessage());
    }
}


public String convertMessage(Throwable throwable){
    String error = throwable.toString();
    String regulation = "\\[\"(.*?)\"]+";
    Pattern pattern = Pattern.compile(regulation);
    Matcher matcher = pattern.matcher(error);
    String group = "";
    if (matcher.find()) {
        String matchString = matcher.group();
        matchString = matchString.replace("[", "").replace("]", "");
        matchString = matchString.replaceAll("\\\"", "") + "字段类型错误";
        group += matchString;
    }
    return group;
}


@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
public Result<T> processException(HttpRequestMethodNotSupportedException e){
    log.info("请求资源不存在:{}", e.getMessage());
    return Result.failed(ResultCode.RESOURCE_NOT_FOUND);
}


}