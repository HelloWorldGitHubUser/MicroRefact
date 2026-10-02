package com.youlai.mall.model.pms.query;
 import com.youlai.mall.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "商品分页查询对象")
@Data
public class SpuPageQuery extends BasePageQuery{

@Schema(description = "关键字")
 private  String keywords;

@Schema(description = "商品分类ID")
 private  Long categoryId;

@Schema(description = "排序字段名")
 private  String sortField;

@Schema(description = "排序规则(asc:升序;desc:降序)")
 private  String sort;


}