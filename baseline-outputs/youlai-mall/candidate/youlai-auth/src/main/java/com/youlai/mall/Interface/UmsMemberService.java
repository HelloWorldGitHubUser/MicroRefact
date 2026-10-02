package com.youlai.mall.Interface;
public interface UmsMemberService {

   public MemberAuthDTO loadUserByMobile(String mobile);
   public MemberAuthDTO loadUserByOpenId(String openid);
   public Long registerMember(MemberRegisterDto dto);
}