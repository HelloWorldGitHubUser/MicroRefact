package com.central.mapper;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
@Mapper
public interface SysUserMapper extends SuperMapper<SysUser>{


public List<SysUser> findList(Page<SysUser> page,Map<String,Object> params)
;

}