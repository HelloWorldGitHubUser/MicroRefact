package com.youlai.mall.mapper;
 import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlai.mall.model.system.bo.RouteBO;
import com.youlai.mall.model.system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Set;
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu>{


public List<RouteBO> listRoutes()
;

}