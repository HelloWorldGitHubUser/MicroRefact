package com.youlai.mall.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.mybatis.annotation.DataPermission;
import com.youlai.mall.model.system.dto.UserAuthInfo;
import com.youlai.mall.model.system.bo.UserBO;
import com.youlai.mall.model.system.bo.UserFormBO;
import com.youlai.mall.model.system.bo.UserProfileBO;
import com.youlai.mall.model.system.entity.SysUser;
import com.youlai.mall.model.system.query.UserPageQuery;
import com.youlai.mall.model.system.vo.UserExportVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser>{


public UserAuthInfo getUserAuthInfo(String username)
;

@DataPermission(deptAlias = "u")
public List<UserExportVO> listExportUsers(UserPageQuery queryParams)
;

@DataPermission(deptAlias = "u")
public Page<UserBO> getUserPage(Page<UserBO> page,UserPageQuery queryParams)
;

public UserFormBO getUserDetail(Long userId)
;

public UserProfileBO getUserProfile(Long userId)
;

}