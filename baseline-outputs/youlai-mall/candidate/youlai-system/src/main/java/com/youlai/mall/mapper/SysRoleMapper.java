package com.youlai.mall.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.mall.model.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import java.util.Set;
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole>{


public Integer getMaxDataRangeDataScope(Set<String> roles)
;

}