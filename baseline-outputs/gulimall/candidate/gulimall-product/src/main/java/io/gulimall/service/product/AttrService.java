package io.gulimall.service.product;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.product.AttrAttrgroupRelationEntity;
import io.gulimall.entity.product.AttrEntity;
import io.gulimall.entity.product.ProductAttrValueEntity;
import io.gulimall.vo.product.AttrRespVo;
import io.gulimall.vo.product.AttrVo;
import java.util.List;
import java.util.Map;
public interface AttrService extends IService<AttrEntity>{


public void saveAttr(AttrVo attr)
;

public List<AttrEntity> getRelationAttr(Long attrgroupId)
;

public List<ProductAttrValueEntity> listAttrsforSpu(Long spuId)
;

public void updateSpuAttrs(Long spuId,List<ProductAttrValueEntity> attrValueEntities)
;

public List<Long> selectSearchAttrIds(List<Long> attrIds)
;

public void updateAttr(AttrVo attr)
;

public PageUtils getNoRelationAttr(Long attrgroupId,Map<String,Object> params)
;

public void saveRelationBatch(List<AttrAttrgroupRelationEntity> attrGroupEntities)
;

public PageUtils queryPage(Map<String,Object> params,long catelogId,String attrType)
;

public AttrRespVo getAttrInfo(Long attrId)
;

}