package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.MemberEntity;
import io.gulimall.vo.member.MemberLoginVo;
import io.gulimall.vo.member.MemberRegisterVo;
import io.gulimall.vo.SocialUser;
import java.util.Map;
public interface MemberService extends IService<MemberEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

public MemberEntity login(SocialUser socialUser)
;

public void register(MemberRegisterVo registerVo)
;

}