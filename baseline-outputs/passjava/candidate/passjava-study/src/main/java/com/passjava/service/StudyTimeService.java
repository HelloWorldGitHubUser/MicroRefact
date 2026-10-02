package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.utils.R;
import com.passjava.entity.StudyTimeEntity;
import java.util.Map;
public interface StudyTimeService extends IService<StudyTimeEntity>{


public R getMemberStudyTimeListTest(Long id)
;

public PageUtils queryPage(Map<String,Object> params)
;

}