package com.youlai.mall.service.system.impl;
 import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.mall.constant.SystemConstants;
import com.youlai.mall.enums.MenuTypeEnum;
import com.youlai.mall.enums.StatusEnum;
import com.youlai.mall.converter.MenuConverter;
import com.youlai.mall.mapper.SysMenuMapper;
import com.youlai.mall.model.system.bo.RouteBO;
import com.youlai.mall.model.system.entity.SysMenu;
import com.youlai.mall.model.system.form.MenuForm;
import com.youlai.mall.model.system.query.MenuQuery;
import com.youlai.mall.model.system.vo.MenuVO;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.model.system.vo.RouteVO;
import com.youlai.mall.service.system.SysMenuService;
import com.youlai.mall.service.system.SysRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>implements SysMenuService{

 private  MenuConverter menuConverter;

 private  SysRoleMenuService roleMenuService;


public List<MenuVO> buildMenuTree(Long parentId,List<SysMenu> menuList){
    return CollectionUtil.emptyIfNull(menuList).stream().filter(menu -> menu.getParentId().equals(parentId)).map(entity -> {
        MenuVO menuVO = menuConverter.entity2Vo(entity);
        List<MenuVO> children = buildMenuTree(entity.getId(), menuList);
        menuVO.setChildren(children);
        return menuVO;
    }).toList();
}


@Override
public boolean deleteMenu(Long id){
    boolean result = this.remove(new LambdaQueryWrapper<SysMenu>().eq(SysMenu::getId, id).or().apply("CONCAT (',',tree_path,',') LIKE CONCAT('%,',{0},',%')", id));
    // 刷新角色权限缓存
    if (result) {
        roleMenuService.refreshRolePermsCache();
    }
    return result;
}


@Override
public List<MenuVO> listMenus(MenuQuery queryParams){
    List<SysMenu> menus = this.list(new LambdaQueryWrapper<SysMenu>().like(StrUtil.isNotBlank(queryParams.getKeywords()), SysMenu::getName, queryParams.getKeywords()).orderByAsc(SysMenu::getSort));
    Set<Long> parentIds = menus.stream().map(SysMenu::getParentId).collect(Collectors.toSet());
    Set<Long> menuIds = menus.stream().map(SysMenu::getId).collect(Collectors.toSet());
    // 获取根节点ID
    List<Long> rootIds = parentIds.stream().filter(id -> !menuIds.contains(id)).toList();
    // 使用递归函数来构建菜单树
    return rootIds.stream().flatMap(rootId -> buildMenuTree(rootId, menus).stream()).collect(Collectors.toList());
}


public RouteVO toRouteVo(RouteBO routeBO){
    RouteVO routeVO = new RouteVO();
    // 路由 name 需要驼峰，首字母大写
    String routeName = StringUtils.capitalize(StrUtil.toCamelCase(routeBO.getPath(), '-'));
    // 根据name路由跳转 this.$router.push({name:xxx})
    routeVO.setName(routeName);
    // 根据path路由跳转 this.$router.push({path:xxx})
    routeVO.setPath(routeBO.getPath());
    routeVO.setRedirect(routeBO.getRedirect());
    routeVO.setComponent(routeBO.getComponent());
    RouteVO.Meta meta = new RouteVO.Meta();
    meta.setTitle(routeBO.getName());
    meta.setIcon(routeBO.getIcon());
    meta.setRoles(routeBO.getRoles());
    meta.setHidden(StatusEnum.DISABLE.getValue().equals(routeBO.getVisible()));
    // 【菜单】是否开启页面缓存
    if (MenuTypeEnum.MENU.equals(routeBO.getType()) && ObjectUtil.equals(routeBO.getKeepAlive(), 1)) {
        meta.setKeepAlive(true);
    }
    // 【目录】只有一个子路由是否始终显示
    if (MenuTypeEnum.CATALOG.equals(routeBO.getType()) && ObjectUtil.equals(routeBO.getAlwaysShow(), 1)) {
        meta.setAlwaysShow(true);
    }
    routeVO.setMeta(meta);
    return routeVO;
}


public List<Option> buildMenuOptions(Long parentId,List<SysMenu> menuList){
    List<Option> menuOptions = new ArrayList<>();
    for (SysMenu menu : menuList) {
        if (menu.getParentId().equals(parentId)) {
            Option option = new Option(menu.getId(), menu.getName());
            List<Option> subMenuOptions = buildMenuOptions(menu.getId(), menuList);
            if (!subMenuOptions.isEmpty()) {
                option.setChildren(subMenuOptions);
            }
            menuOptions.add(option);
        }
    }
    return menuOptions;
}


public List<RouteVO> buildRoutes(Long parentId,List<RouteBO> menuList){
    List<RouteVO> routeList = new ArrayList<>();
    for (RouteBO menu : menuList) {
        if (menu.getParentId().equals(parentId)) {
            RouteVO routeVO = toRouteVo(menu);
            List<RouteVO> children = buildRoutes(menu.getId(), menuList);
            if (!children.isEmpty()) {
                routeVO.setChildren(children);
            }
            routeList.add(routeVO);
        }
    }
    return routeList;
}


@Override
public List<Option> listMenuOptions(){
    List<SysMenu> menuList = this.list(new LambdaQueryWrapper<SysMenu>().orderByAsc(SysMenu::getSort));
    return buildMenuOptions(SystemConstants.ROOT_NODE_ID, menuList);
}


@Override
public boolean updateMenuVisible(Long menuId,Integer visible){
    return this.update(new LambdaUpdateWrapper<SysMenu>().eq(SysMenu::getId, menuId).set(SysMenu::getVisible, visible));
}


@Override
public MenuForm getMenuForm(Long id){
    SysMenu entity = this.getById(id);
    return menuConverter.entity2Form(entity);
}


@Override
@Cacheable(cacheNames = "menu", key = "'routes'")
public List<RouteVO> listRoutes(){
    List<RouteBO> menuList = this.baseMapper.listRoutes();
    return buildRoutes(SystemConstants.ROOT_NODE_ID, menuList);
}


@Override
public boolean saveMenu(MenuForm menuForm){
    String path = menuForm.getPath();
    MenuTypeEnum menuType = menuForm.getType();
    // 如果是目录
    if (menuType == MenuTypeEnum.CATALOG) {
        if (menuForm.getParentId() == 0 && !path.startsWith("/")) {
            // 一级目录需以 / 开头
            menuForm.setPath("/" + path);
        }
        menuForm.setComponent("Layout");
    } else // 如果是外链
    if (menuType == MenuTypeEnum.EXTLINK) {
        menuForm.setComponent(null);
    }
    SysMenu entity = menuConverter.form2Entity(menuForm);
    String treePath = generateMenuTreePath(menuForm.getParentId());
    entity.setTreePath(treePath);
    boolean result = this.saveOrUpdate(entity);
    if (result) {
        // 编辑刷新角色权限缓存
        if (menuForm.getId() != null) {
            roleMenuService.refreshRolePermsCache();
        }
    }
    return result;
}


public String generateMenuTreePath(Long parentId){
    if (SystemConstants.ROOT_NODE_ID.equals(parentId)) {
        return String.valueOf(parentId);
    } else {
        SysMenu parent = this.getById(parentId);
        return parent != null ? parent.getTreePath() + "," + parent.getId() : null;
    }
}


}