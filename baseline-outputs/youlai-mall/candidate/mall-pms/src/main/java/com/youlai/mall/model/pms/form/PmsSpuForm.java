package com.youlai.mall.model.pms.form;
 import com.youlai.mall.model.pms.entity.PmsSku;
import lombok.Data;
import java.util.List;
@Data
public class PmsSpuForm {

 private  Long id;

 private  String name;

 private  Long categoryId;

 private  Long brandId;

 private  Long originPrice;

 private  Long price;

 private  String picUrl;

 private  String[] subPicUrls;

 private  String description;

 private  String detail;

 private  List<PmsSpuAttributeForm> attrList;

 private  List<PmsSpuAttributeForm> specList;

 private  List<PmsSku> skuList;


}