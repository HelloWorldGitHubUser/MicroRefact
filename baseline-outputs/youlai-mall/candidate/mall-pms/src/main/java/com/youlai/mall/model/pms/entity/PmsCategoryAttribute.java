package com.youlai.mall.model.pms.entity;
 import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.youlai.mall.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PmsCategoryAttribute extends BaseEntity{

@TableId(type = IdType.AUTO)
 private  Long id;

 private  Long categoryId;

 private  String name;

 private  Integer type;


}