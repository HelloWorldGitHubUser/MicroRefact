package ltd.newbee.mall.api.DTO;
 import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
public class Result implements Serializable{

 private  long serialVersionUID;

 private  int resultCode;

 private  String message;

 private  T data;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://5";

public Result() {
}public Result(int resultCode, String message) {
    this.resultCode = resultCode;
    this.message = message;
}
public int getResultCode(){
    return resultCode;
}


public String getMessage(){
    return message;
}


public T getData(){
    return data;
}


public void setData(T data){
    this.data = data;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setData"))

.queryParam("data",data)
;
restTemplate.put(builder.toUriString(),null);
}


}