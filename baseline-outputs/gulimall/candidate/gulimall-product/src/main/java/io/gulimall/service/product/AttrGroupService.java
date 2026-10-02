package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.AttrGroupEntity;
import io.gulimall.vo.product.AttrGroupWithAttrVo;
import java.util.List;
import java.util.Map;
public interface AttrGroupService extends IService<AttrGroupEntity>{


public List<AttrGroupWithAttrVo> getAttrGroupWithAttrByCatelogId(Long catId)
;

public PageUtils queryPage(Map<String,Object> params,long catelogId)
;

}