package com.goodskill.handler;
 import com.goodskill.dto.ApiResult;
import com.goodskill.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.stream.Collectors;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.OK)
public ApiResult<Void> exception(MethodArgumentNotValidException e){
    String errorMsg = e.getBindingResult().getFieldErrors().stream().map(errorInfo -> errorInfo.getField() + errorInfo.getDefaultMessage()).collect(Collectors.joining(","));
    log.warn(e.getMessage(), e);
    return ApiResult.error(ResultCode.C500.getCode(), "参数校验失败:" + errorMsg);
}


}