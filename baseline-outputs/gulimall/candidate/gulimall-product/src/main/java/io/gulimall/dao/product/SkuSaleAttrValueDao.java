package io.gulimall.dao.product;
 import io.gulimall.entity.product.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.gulimall.vo.product.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity>{


public List<SkuItemSaleAttrVo> listSaleAttrs(Long spuId)
;

public List<String> getSkuSaleAttrValuesAsString(Long skuId)
;

}