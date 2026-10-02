package com.youlai.mall.service.pms;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.pms.entity.PmsSpu;
import com.youlai.mall.model.pms.form.PmsSpuForm;
import com.youlai.mall.model.pms.query.SpuPageQuery;
import com.youlai.mall.model.pms.vo;
import java.util.List;
public interface SpuService extends IService<PmsSpu>{


public boolean updateSpuById(Long spuId,PmsSpuForm formData)
;

public boolean addSpu(PmsSpuForm formData)
;

public PmsSpuDetailVO getSpuDetail(Long id)
;

public boolean removeBySpuIds(String ids)
;

public SpuDetailVO getSpuDetailForApp(Long spuId)
;

public List<SeckillingSpuVO> listSeckillingSpu()
;

public IPage<SpuPageVO> listPagedSpuForApp(SpuPageQuery queryParams)
;

public IPage<PmsSpuPageVO> listPagedSpu(SpuPageQuery queryParams)
;

}