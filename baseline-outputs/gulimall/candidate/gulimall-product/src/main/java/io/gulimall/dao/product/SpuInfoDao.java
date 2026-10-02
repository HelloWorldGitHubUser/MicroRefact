package io.gulimall.dao.product;
 import io.gulimall.entity.product.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity>{


public void upSpuStatus(Long spuId,int code)
;

}