package com.central.mapper;
 import com.central.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface SysMenuMapper extends SuperMapper<SysMenu>{


public List<SysMenu> findByUserId(Long userId,Integer type)
;

}