package ltd.newbee.mall.util;
 import org.springframework.util.StringUtils;
public class ResultGenerator {

 private  String DEFAULT_SUCCESS_MESSAGE;

 private  String DEFAULT_FAIL_MESSAGE;

 private  int RESULT_CODE_SUCCESS;

 private  int RESULT_CODE_SERVER_ERROR;


public Result genErrorResult(int code,String message){
    Result result = new Result();
    result.setResultCode(code);
    result.setMessage(message);
    return result;
}


public Result genSuccessResult(Object data){
    Result result = new Result();
    result.setResultCode(RESULT_CODE_SUCCESS);
    result.setMessage(DEFAULT_SUCCESS_MESSAGE);
    result.setData(data);
    return result;
}


public Result genFailResult(String message){
    Result result = new Result();
    result.setResultCode(RESULT_CODE_SERVER_ERROR);
    if (!StringUtils.hasText(message)) {
        result.setMessage(DEFAULT_FAIL_MESSAGE);
    } else {
        result.setMessage(message);
    }
    return result;
}


}