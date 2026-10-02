package io.gulimall.dao.product;
 import io.gulimall.entity.product.ProductAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.gulimall.vo.product.SpuItemAttrGroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface ProductAttrValueDao extends BaseMapper<ProductAttrValueEntity>{


public List<SpuItemAttrGroupVo> getProductGroupAttrsBySpuId(Long spuId,Long catalogId)
;

}