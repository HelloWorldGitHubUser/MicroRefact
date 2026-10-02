package com.youlai.mall.converter;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.model.sms.entity.SmsAdvert;
import com.youlai.mall.model.sms.vo.BannerVO;
import com.youlai.mall.model.sms.vo.AdvertPageVO;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface AdvertConverter {


public Page<AdvertPageVO> entity2PageVo(Page<SmsAdvert> po)
;

public List<BannerVO> entity2BannerVo(List<SmsAdvert> entities)
;

}