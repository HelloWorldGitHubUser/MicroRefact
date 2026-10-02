package com.youlai.mall.service.system.impl;
 import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.mall.constant.SystemConstants;
import com.youlai.mall.enums.StatusEnum;
import com.youlai.mall.converter.DeptConverter;
import com.youlai.mall.mapper.SysDeptMapper;
import com.youlai.mall.model.system.entity.SysDept;
import com.youlai.mall.model.system.form.DeptForm;
import com.youlai.mall.model.system.query.DeptQuery;
import com.youlai.mall.model.system.vo.DeptVO;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.service.system.SysDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept>implements SysDeptService{

 private  DeptConverter deptConverter;


@Override
public List<DeptVO> listDepartments(DeptQuery queryParams){
    // 查询参数
    String keywords = queryParams.getKeywords();
    Integer status = queryParams.getStatus();
    // 查询数据
    List<SysDept> deptList = this.list(new LambdaQueryWrapper<SysDept>().like(StrUtil.isNotBlank(keywords), SysDept::getName, keywords).eq(status != null, SysDept::getStatus, status).orderByAsc(SysDept::getSort));
    Set<Long> deptIds = deptList.stream().map(SysDept::getId).collect(Collectors.toSet());
    Set<Long> parentIds = deptList.stream().map(SysDept::getParentId).collect(Collectors.toSet());
    List<Long> rootIds = CollectionUtil.subtractToList(parentIds, deptIds);
    List<DeptVO> list = new ArrayList<>();
    for (Long rootId : rootIds) {
        list.addAll(recurDeptList(rootId, deptList));
    }
    return list;
}


public List<Option> recurDeptTreeOptions(long parentId,List<SysDept> deptList){
    List<Option> list = CollectionUtil.emptyIfNull(deptList).stream().filter(dept -> dept.getParentId().equals(parentId)).map(dept -> {
        Option option = new Option(dept.getId(), dept.getName());
        List<Option> children = recurDeptTreeOptions(dept.getId(), deptList);
        if (CollectionUtil.isNotEmpty(children)) {
            option.setChildren(children);
        }
        return option;
    }).collect(Collectors.toList());
    return list;
}


public List<DeptVO> recurDeptList(Long parentId,List<SysDept> deptList){
    return deptList.stream().filter(dept -> dept.getParentId().equals(parentId)).map(dept -> {
        DeptVO deptVO = deptConverter.entity2Vo(dept);
        List<DeptVO> children = recurDeptList(dept.getId(), deptList);
        deptVO.setChildren(children);
        return deptVO;
    }).collect(Collectors.toList());
}


public String generateDeptTreePath(Long parentId){
    String treePath = null;
    if (SystemConstants.ROOT_NODE_ID.equals(parentId)) {
        treePath = String.valueOf(parentId);
    } else {
        SysDept parent = this.getById(parentId);
        if (parent != null) {
            treePath = parent.getTreePath() + "," + parent.getId();
        }
    }
    return treePath;
}


@Override
public DeptForm getDeptForm(Long deptId){
    SysDept entity = this.getOne(new LambdaQueryWrapper<SysDept>().eq(SysDept::getId, deptId).select(SysDept::getId, SysDept::getName, SysDept::getParentId, SysDept::getStatus, SysDept::getSort));
    return deptConverter.entity2Form(entity);
}


@Override
public Long updateDept(Long deptId,DeptForm formData){
    // form->entity
    SysDept entity = deptConverter.form2Entity(formData);
    entity.setId(deptId);
    // 部门路径
    String treePath = generateDeptTreePath(formData.getParentId());
    entity.setTreePath(treePath);
    // 保存部门并返回部门ID
    this.updateById(entity);
    return entity.getId();
}


@Override
public Long saveDept(DeptForm formData){
    SysDept entity = deptConverter.form2Entity(formData);
    // 部门路径
    String treePath = generateDeptTreePath(formData.getParentId());
    entity.setTreePath(treePath);
    // 保存部门并返回部门ID
    this.save(entity);
    return entity.getId();
}


@Override
public boolean deleteByIds(String ids){
    // 删除部门及子部门
    if (StrUtil.isNotBlank(ids)) {
        String[] menuIds = ids.split(",");
        for (String deptId : menuIds) {
            this.remove(new LambdaQueryWrapper<SysDept>().eq(SysDept::getId, deptId).or().apply("CONCAT (',',tree_path,',') LIKE CONCAT('%,',{0},',%')", deptId));
        }
    }
    return true;
}


@Override
public List<Option> listDeptOptions(){
    List<SysDept> deptList = this.list(new LambdaQueryWrapper<SysDept>().eq(SysDept::getStatus, StatusEnum.ENABLE.getValue()).select(SysDept::getId, SysDept::getParentId, SysDept::getName).orderByAsc(SysDept::getSort));
    Set<Long> parentIds = deptList.stream().map(SysDept::getParentId).collect(Collectors.toSet());
    Set<Long> deptIds = deptList.stream().map(SysDept::getId).collect(Collectors.toSet());
    List<Long> rootIds = CollectionUtil.subtractToList(parentIds, deptIds);
    List<Option> list = new ArrayList<>();
    for (Long rootId : rootIds) {
        list.addAll(recurDeptTreeOptions(rootId, deptList));
    }
    return list;
}


}