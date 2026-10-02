package ltd.newbee.mall.api.admin;
 import io.swagger.annotations.Api;
import ltd.newbee.mall.api.admin.param.AdminLoginParam;
import ltd.newbee.mall.api.admin.param.UpdateAdminNameParam;
import ltd.newbee.mall.api.admin.param.UpdateAdminPasswordParam;
import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.config.annotation.TokenToAdminUser;
import ltd.newbee.mall.entity.AdminUser;
import ltd.newbee.mall.entity.AdminUserToken;
import ltd.newbee.mall.service.AdminUserService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
import ltd.newbee.mall.api.DTO.Result;
@RestController
@Api(value = "v1", tags = "8-0.后台管理系统管理员模块接口")
@RequestMapping("/manage-api/v1")
public class NewBeeAdminManageUserAPI {

@Resource
 private  AdminUserService adminUserService;

 private  Logger logger;


@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
public Result logout(AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    adminUserService.logout(adminUser.getAdminUserId());
    return ResultGenerator.genSuccessResult();
}


@RequestMapping(value = "/adminUser/name", method = RequestMethod.PUT)
public Result nameUpdate(UpdateAdminNameParam adminNameParam,AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    if (adminUserService.updateName(adminUser.getAdminUserId(), adminNameParam.getLoginUserName(), adminNameParam.getNickName())) {
        return ResultGenerator.genSuccessResult();
    } else {
        return ResultGenerator.genFailResult(ServiceResultEnum.DB_ERROR.getResult());
    }
}


@RequestMapping(value = "/adminUser/password", method = RequestMethod.PUT)
public Result passwordUpdate(UpdateAdminPasswordParam adminPasswordParam,AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    if (adminUserService.updatePassword(adminUser.getAdminUserId(), adminPasswordParam.getOriginalPassword(), adminPasswordParam.getNewPassword())) {
        return ResultGenerator.genSuccessResult();
    } else {
        return ResultGenerator.genFailResult(ServiceResultEnum.DB_ERROR.getResult());
    }
}


@RequestMapping(value = "/adminUser/profile", method = RequestMethod.GET)
public Result profile(AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    AdminUser adminUserEntity = adminUserService.getUserDetailById(adminUser.getAdminUserId());
    if (adminUserEntity != null) {
        adminUserEntity.setLoginPassword("******");
        Result result = ResultGenerator.genSuccessResult();
        result.setData(adminUserEntity);
        return result;
    }
    return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
}


@RequestMapping(value = "/adminUser/login", method = RequestMethod.POST)
public Result<String> login(AdminLoginParam adminLoginParam){
    String loginResult = adminUserService.login(adminLoginParam.getUserName(), adminLoginParam.getPasswordMd5());
    logger.info("manage login api,adminName={},loginResult={}", adminLoginParam.getUserName(), loginResult);
    // 登录成功
    if (StringUtils.hasText(loginResult) && loginResult.length() == Constants.TOKEN_LENGTH) {
        Result result = ResultGenerator.genSuccessResult();
        result.setData(loginResult);
        return result;
    }
    // 登录失败
    return ResultGenerator.genFailResult(loginResult);
}


}