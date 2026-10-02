package io.gulimall.vo.search;
 import io.gulimall.to.es.SkuEsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
public class SearchResult {

 private  List<SkuEsModel> product;

 private  Integer pageNum;

 private  Long total;

 private  Integer totalPages;

 private  List<Integer> pageNavs;

 private  List<BrandVo> brands;

 private  List<AttrVo> attrs;

 private  List<CatalogVo> catalogs;

 private  List<NavVo> navs;

 private  String navName;

 private  String navValue;

 private  String link;

 private  Long brandId;

 private  String brandName;

 private  String brandImg;

 private  Long attrId;

 private  String attrName;

 private  List<String> attrValue;

 private  Long catalogId;

 private  String catalogName;


}