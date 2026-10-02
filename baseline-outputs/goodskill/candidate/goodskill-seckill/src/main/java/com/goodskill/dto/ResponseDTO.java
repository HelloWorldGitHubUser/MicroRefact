package com.goodskill.dto;
 import com.goodskill.enums.ResponseInfo;
import lombok.Data;
import java.io.Serializable;
@Data
public class ResponseDTO implements Serializable{

 private  String code;

 private  String msg;

 private  int count;

 private  T[] data;


public ResponseDTO fail(){
    return getResponseDto(ResponseInfo.FAIL);
}


public ResponseDTO ok(T[] obj){
    ResponseDTO responseDto = getResponseDto(ResponseInfo.SUCCESS);
    responseDto.setData(obj);
    return responseDto;
}


public ResponseDTO getResponseDto(ResponseInfo responseInfo){
    ResponseDTO responseDto = new ResponseDTO();
    responseDto.setCode(responseInfo.getCode());
    responseDto.setMsg(responseInfo.getMessage());
    return responseDto;
}


}