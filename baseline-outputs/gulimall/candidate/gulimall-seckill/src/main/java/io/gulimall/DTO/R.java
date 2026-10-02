package io.gulimall.DTO;
 import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
public class R extends HashMap<String, Object>{

 private  long serialVersionUID;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://10";

public R() {
    put("code", 0);
    put("msg", "success");
}
public Integer getCode(){
    return (Integer) this.get("code");
}


public T getData(String key,TypeReference<T> tTypeReference){
    Object data = this.get(key);
    String toJSONString = JSON.toJSONString(data);
    T t = JSON.parseObject(toJSONString, tTypeReference);
    return t;
}


public R ok(){
    return new R();
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/ok"))

;
R aux = restTemplate.getForObject(builder.toUriString(),R.class);
return aux;
}


public R setData(Object data){
    put("data", data);
    return this;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setData"))

.queryParam("data",data)
;
R aux = restTemplate.getForObject(builder.toUriString(),R.class);
return aux;
}


}