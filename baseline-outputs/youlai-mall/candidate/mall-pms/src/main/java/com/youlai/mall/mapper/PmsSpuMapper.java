package com.youlai.mall.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.pms.entity.PmsSpu;
import com.youlai.mall.model.pms.query.SpuPageQuery;
import com.youlai.mall.model.pms.vo.PmsSpuPageVO;
import com.youlai.mall.model.pms.vo.SpuPageVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface PmsSpuMapper extends BaseMapper<PmsSpu>{


public List<SpuPageVO> listPagedSpuForApp(Page<SpuPageVO> page,SpuPageQuery queryParams)
;

public List<PmsSpuPageVO> listPagedSpu(Page<PmsSpuPageVO> page,SpuPageQuery queryParams)
;

}