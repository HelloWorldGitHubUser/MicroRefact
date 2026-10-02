package io.gulimall.vo.product;
 import io.gulimall.entity.product.SkuImagesEntity;
import io.gulimall.entity.product.SkuInfoEntity;
import io.gulimall.entity.product.SpuInfoDescEntity;
import lombok.Data;
import lombok.ToString;
import java.util.List;
@ToString
@Data
public class SkuItemVo {

 private  SkuInfoEntity info;

 private  boolean hasStock;

 private  List<SkuImagesEntity> images;

 private  List<SkuItemSaleAttrVo> saleAttr;

 private  SpuInfoDescEntity desc;

 private  List<SpuItemAttrGroupVo> groupAttrs;

 private  SeckillSkuVo seckillSkuVo;


}