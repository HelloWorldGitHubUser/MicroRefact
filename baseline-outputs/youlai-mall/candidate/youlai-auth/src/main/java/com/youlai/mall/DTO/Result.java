package com.youlai.mall.DTO;
 import lombok.Data;
import java.io.Serializable;
public class Result implements Serializable{

 private  String code;

 private  T data;

 private  String msg;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://6";


public Result<T> failed(IResultCode resultCode,String msg){
    return result(resultCode.getCode(), msg, null);
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/failed"))

.queryParam("resultCode",resultCode)
.queryParam("msg",msg)
;
Result<T> aux = restTemplate.getForObject(builder.toUriString(),Result<T>.class);
return aux;
}


public Result<T> judge(boolean status){
    if (status) {
        return success();
    } else {
        return failed();
    }
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/judge"))

.queryParam("status",status)
;
Result<T> aux = restTemplate.getForObject(builder.toUriString(),Result<T>.class);
return aux;
}


public Result<T> success(T data){
    Result<T> result = new Result<>();
    result.setCode(ResultCode.SUCCESS.getCode());
    result.setMsg(ResultCode.SUCCESS.getMsg());
    result.setData(data);
    return result;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/success"))

.queryParam("data",data)
;
Result<T> aux = restTemplate.getForObject(builder.toUriString(),Result<T>.class);
return aux;
}


}