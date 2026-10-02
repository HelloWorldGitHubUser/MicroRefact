package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.entity.SysMenu;
import com.youlai.mall.model.system.form.MenuForm;
import com.youlai.mall.model.system.query.MenuQuery;
import com.youlai.mall.model.system.vo.MenuVO;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.model.system.vo.RouteVO;
import java.util.List;
import java.util.Set;
public interface SysMenuService extends IService<SysMenu>{


public boolean deleteMenu(Long id)
;

public List<MenuVO> listMenus(MenuQuery queryParams)
;

public List<Option> listMenuOptions()
;

public boolean updateMenuVisible(Long menuId,Integer visible)
;

public MenuForm getMenuForm(Long id)
;

public boolean saveMenu(MenuForm menu)
;

public List<RouteVO> listRoutes()
;

}