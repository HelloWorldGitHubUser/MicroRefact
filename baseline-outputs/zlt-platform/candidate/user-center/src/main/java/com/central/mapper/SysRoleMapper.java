package com.central.mapper;
 import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRoleMapper extends SuperMapper<SysRole>{


public List<SysRole> findList(Page<SysRole> page,Map<String,Object> params)
;

public List<SysRole> findAll()
;

}