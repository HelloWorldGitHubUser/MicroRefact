package com.youlai.mall.DTO;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import java.io.Serializable;
import java.util.List;
public class PageResult implements Serializable{

 private  String code;

 private  Data<T> data;

 private  String msg;

 private  List<T> list;

 private  long total;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://6";


public PageResult<T> success(IPage<T> page){
    PageResult<T> result = new PageResult<>();
    result.setCode(ResultCode.SUCCESS.getCode());
    Data data = new Data<T>();
    data.setList(page.getRecords());
    data.setTotal(page.getTotal());
    result.setData(data);
    result.setMsg(ResultCode.SUCCESS.getMsg());
    return result;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/success"))

.queryParam("page",page)
;
PageResult<T> aux = restTemplate.getForObject(builder.toUriString(),PageResult<T>.class);
return aux;
}


}