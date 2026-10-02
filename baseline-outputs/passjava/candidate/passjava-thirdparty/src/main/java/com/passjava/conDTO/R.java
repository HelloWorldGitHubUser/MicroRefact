package com.passjava.conDTO;
 import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
public class R extends HashMap<String, Object>{

 private  long serialVersionUID;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://7";

public R() {
    put("code", 0);
    put("msg", "success");
}
public R error(int code,String msg){
    R r = new R();
    r.put("code", code);
    r.put("msg", msg);
    return r;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/error"))

.queryParam("code",code)
.queryParam("msg",msg)
;
R aux = restTemplate.getForObject(builder.toUriString(),R.class);
return aux;
}


public R ok(){
    return new R();
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/ok"))

;
R aux = restTemplate.getForObject(builder.toUriString(),R.class);
return aux;
}


public R put(String key,Object value){
    super.put(key, value);
    return this;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/put"))

.queryParam("key",key)
.queryParam("value",value)
;
R aux = restTemplate.getForObject(builder.toUriString(),R.class);
return aux;
}


}