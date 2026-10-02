package io.gulimall.vo.search.SearchResult;
 import io.gulimall.to.es.SkuEsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class BrandVo {

 private  Long brandId;

 private  String brandName;

 private  String brandImg;


}