package io.gulimall.vo.search.SearchResult;
 import io.gulimall.to.es.SkuEsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class AttrVo {

 private  Long attrId;

 private  String attrName;

 private  List<String> attrValue;


}