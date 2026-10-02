package com.youlai.mall.service.sms;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.sms.entity.SmsAdvert;
import com.youlai.mall.model.sms.query.AdvertPageQuery;
import com.youlai.mall.model.sms.vo.BannerVO;
import com.youlai.mall.model.sms.vo.AdvertPageVO;
import java.util.List;
public interface SmsAdvertService extends IService<SmsAdvert>{


public Page<AdvertPageVO> getAdvertPage(AdvertPageQuery queryParams)
;

public List<BannerVO> getBannerList()
;

}