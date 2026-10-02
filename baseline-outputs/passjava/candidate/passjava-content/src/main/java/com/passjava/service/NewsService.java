package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.NewsEntity;
import java.util.Map;
public interface NewsService extends IService<NewsEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

}