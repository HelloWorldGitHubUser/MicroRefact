package io.gulimall.controller.auth;
 import io.gulimall.vo.auth.UserLoginVo;
import io.gulimall.constant.AuthServerConstant;
import io.gulimall.exception.BizCodeEnum;
import io.gulimall.utils.R;
import io.gulimall.vo.MemberResponseVo;
import io.gulimall.entity.member.MemberEntity;
import io.gulimall.service.member.MemberService;
import io.gulimall.vo.member.MemberLoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import io.gulimall.Interface.MemberService;
import io.gulimall.DTO.R;
@RestController
@RequestMapping("/api/auth")
public class AuthApiController {

@Autowired
 private  MemberService memberService;

@Autowired
 private  StringRedisTemplate redisTemplate;


@GetMapping("/user")
public R getCurrentUser(HttpSession session,String headerSessionId){
    // 如果通过 Header 传递了 sessionId，尝试从 Redis 中获取 Session
    HttpSession targetSession = session;
    if (headerSessionId != null && !headerSessionId.equals(session.getId())) {
    // 注意：这里只是示例，实际 Spring Session 会自动处理
    // 如果 Header 中的 sessionId 与当前 session 不同，说明 Cookie 没有正确传递
    }
    // 调试信息
    String sessionId = session.getId();
    Object loginUser = session.getAttribute(AuthServerConstant.LOGIN_USER);
    MemberResponseVo memberResponseVo = (MemberResponseVo) loginUser;
    if (memberResponseVo != null) {
        return R.ok().put("memberEntity", memberResponseVo).put("sessionId", sessionId).put("debug", "Session中存在用户信息");
    } else {
        // 返回调试信息
        return R.error(401, "未登录").put("sessionId", sessionId).put("sessionIsNew", session.isNew()).put("headerSessionId", headerSessionId).put("debug", "Session中不存在用户信息。请确认：1) Cookie是否正确发送 2) 或使用 Header: X-Session-Id");
    }
}


@PostMapping("/logout")
public R logout(HttpSession session){
    session.invalidate();
    return R.ok().put("msg", "登出成功");
}


@GetMapping("/test/code")
public R generateTestCode(String phone){
    // 6位随机数
    String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    String redisKey = AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone;
    redisTemplate.opsForValue().set(redisKey, code + "_" + System.currentTimeMillis(), 5, java.util.concurrent.TimeUnit.MINUTES);
    return R.ok().put("code", code).put("phone", phone).put("msg", "测试验证码（仅用于开发测试）");
}


@PostMapping("/login")
public R login(UserLoginVo vo,HttpSession session){
    MemberLoginVo memberLoginVo = new MemberLoginVo();
    memberLoginVo.setLoginAccount(vo.getLoginacct());
    memberLoginVo.setPassword(vo.getPassword());
    MemberEntity entity = memberService.login(memberLoginVo);
    if (entity != null) {
        MemberResponseVo memberResponseVo = new MemberResponseVo();
        BeanUtils.copyProperties(entity, memberResponseVo);
        session.setAttribute(AuthServerConstant.LOGIN_USER, memberResponseVo);
        String sessionId = session.getId();
        return R.ok().put("memberEntity", memberResponseVo).put("sessionId", sessionId).put("cookieName", "JSESSIONID").put("cookieValue", sessionId).put("cookieHeader", "Cookie: JSESSIONID=" + sessionId).put("debug", "请在后续请求的 Headers 中添加: Cookie: JSESSIONID=" + sessionId);
    } else {
        return R.error(BizCodeEnum.LOGINACCT_PASSWORD_EXCEPTION.getCode(), BizCodeEnum.LOGINACCT_PASSWORD_EXCEPTION.getMsg());
    }
}


}