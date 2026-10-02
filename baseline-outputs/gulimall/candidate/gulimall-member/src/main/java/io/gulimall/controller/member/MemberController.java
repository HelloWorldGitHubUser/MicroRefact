package io.gulimall.controller.member;
 import java.util.Arrays;
import java.util.Map;
import io.gulimall.exception.BizCodeEnum;
import io.gulimall.exception.PhoneNumExistException;
import io.gulimall.exception.UserExistException;
import io.gulimall.service.coupon.CouponService;
import io.gulimall.vo.member.MemberLoginVo;
import io.gulimall.vo.member.MemberRegisterVo;
import io.gulimall.vo.SocialUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.member.MemberEntity;
import io.gulimall.service.member.MemberService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
import io.gulimall.security.LoginRequired;
import io.gulimall.Interface.CouponService;
@RestController
@RequestMapping("member/member")
public class MemberController {

@Autowired
 private  MemberService memberService;

@Autowired
 private  CouponService couponService;


@RequestMapping("/coupons")
@LoginRequired
public R test(){
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setNickname("zhangsan");
    return R.ok().put("member", memberEntity).put("coupons", couponService.listMemberCoupons());
}


@RequestMapping("/save")
@LoginRequired
public R save(MemberEntity member){
    memberService.save(member);
    return R.ok();
}


@RequestMapping("/update")
@LoginRequired
public R update(MemberEntity member){
    memberService.updateById(member);
    return R.ok();
}


@RequestMapping("/oauth2/login")
public R login(SocialUser socialUser){
    MemberEntity entity = memberService.login(socialUser);
    if (entity != null) {
        return R.ok().put("memberEntity", entity);
    } else {
        return R.error();
    }
}


@RequestMapping("/list")
@LoginRequired
public R list(Map<String,Object> params){
    PageUtils page = memberService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
@LoginRequired
public R delete(Long[] ids){
    memberService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/register")
public R register(MemberRegisterVo registerVo){
    try {
        memberService.register(registerVo);
    } catch (UserExistException userException) {
        return R.error(BizCodeEnum.USER_EXIST_EXCEPTION.getCode(), BizCodeEnum.USER_EXIST_EXCEPTION.getMsg());
    } catch (PhoneNumExistException phoneException) {
        return R.error(BizCodeEnum.PHONE_EXIST_EXCEPTION.getCode(), BizCodeEnum.PHONE_EXIST_EXCEPTION.getMsg());
    }
    return R.ok();
}


@RequestMapping("/info/{id}")
@LoginRequired
public R info(Long id){
    MemberEntity member = memberService.getById(id);
    return R.ok().put("member", member);
}


}