package com.goodskill.dto;
 import com.goodskill.enums.ResultCode;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
@Data
public class ApiResult implements Serializable{

@Serial
 private  long serialVersionUID;

 private  int code;

 private  String msg;

 private  T data;

 private  boolean isSuccess;

 private  String version;

public ApiResult() {
    this.setCode(ResultCode.C200.getCode());
    this.setMsg(ResultCode.C200.getDesc());
    this.setSuccess(true);
    this.setVersion(ResultCode.C606.getDesc());
}public ApiResult(int code, String message, boolean success, T dataMap, String version) {
    this.setCode(code);
    this.setMsg(message);
    this.setSuccess(success);
    this.setData(dataMap);
    this.setVersion(version);
}
public void setFormatMessage(String message,Object args){
    if (args != null && args.length != 0) {
        this.setMsg(String.format(message, args));
    } else {
        this.setMsg(message);
    }
}


public ApiResult<T> newInstance(ResultCode resultCode,boolean success,T value,String version){
    return new ApiResult(resultCode.getCode(), resultCode.getDesc(), success, value, version);
}


public ApiResult<T> ok(T value){
    return new ApiResult(ResultCode.C200.getCode(), ResultCode.C200.getDesc(), true, value, ResultCode.C606.getDesc());
}


public ApiResult<T> error(int code,String message,Object result,String version){
    return new ApiResult(code, message, false, result, version);
}


public ApiResult<T> setErrorCode(ResultCode errorCode,Object args){
    if (errorCode == null) {
        return null;
    } else {
        this.code = errorCode.getCode();
        this.setFormatMessage(errorCode.getDesc(), args);
        this.isSuccess = false;
        this.version = ResultCode.C606.getDesc();
        return this;
    }
}


}