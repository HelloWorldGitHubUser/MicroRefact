package com.passjava.service;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.passjava.utils.PageUtils;
import com.passjava.entity.MemberEntity;
import java.util.Map;
public interface MemberService extends IService<MemberEntity>{


public MemberEntity getMemberByUserId(String userId)
;

public String sendCoupon(int num) throws Exception
;

public PageUtils queryPage(Map<String,Object> params)
;

}