package com.youlai.mall.model.pms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.Data;
@Data
public class PmsCategoryBrand extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long categoryId;

 private  Long brandId;


}