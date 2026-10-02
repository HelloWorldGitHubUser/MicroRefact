package io.gulimall.dao.product;
 import io.gulimall.entity.product.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity>{


public List<Long> selectSearchAttrIds(List<Long> attrIds)
;

}