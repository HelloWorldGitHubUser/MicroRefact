package com.passjava.dao;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.passjava.entity.QuestionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;
@Mapper
public interface QuestionDao extends BaseMapper<QuestionEntity>{


public IPage<QuestionEntity> selectPage1(IPage<QuestionEntity> page,Map<String,Object> params)
;

public List<QuestionEntity> listForApp(String type)
;

}