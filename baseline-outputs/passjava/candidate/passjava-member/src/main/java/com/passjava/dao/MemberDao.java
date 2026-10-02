package com.passjava.dao;
 import com.passjava.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity>{


public MemberEntity getMemberByUserId(String userId)
;

}