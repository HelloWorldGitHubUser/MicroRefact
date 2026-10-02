package com.youlai.mall.service.pms.impl;
 import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.mall.constant.GlobalConstants;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.mapper.PmsCategoryMapper;
import com.youlai.mall.model.pms.entity.PmsCategory;
import com.youlai.mall.model.pms.vo.CategoryVO;
import com.youlai.mall.service.pms.CategoryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory>implements CategoryService{


@Override
public List<CategoryVO> getCategoryList(Long parentId){
    List<PmsCategory> categoryList = this.list(new LambdaQueryWrapper<PmsCategory>().eq(PmsCategory::getVisible, GlobalConstants.STATUS_YES).orderByDesc(PmsCategory::getSort));
    List<CategoryVO> list = recursionTree(parentId != null ? parentId : 0l, categoryList);
    return list;
}


@Override
public List<Option> getCategoryOptions(){
    List<PmsCategory> categoryList = this.list(new LambdaQueryWrapper<PmsCategory>().eq(PmsCategory::getVisible, GlobalConstants.STATUS_YES).orderByAsc(PmsCategory::getSort));
    List<Option> list = recursionCascade(0l, categoryList);
    return list;
}


@CacheEvict(value = "pms", key = "'categoryList'")
@Override
public Long saveCategory(PmsCategory category){
    this.saveOrUpdate(category);
    return category.getId();
}


public List<Option> recursionCascade(Long parentId,List<PmsCategory> categoryList){
    List<Option> list = new ArrayList<>();
    Optional.ofNullable(categoryList).ifPresent(categories -> categories.stream().filter(category -> category.getParentId().equals(parentId)).forEach(category -> {
        Option categoryVO = new Option<>(category.getId(), category.getName());
        BeanUtil.copyProperties(category, categoryVO);
        List<Option> children = recursionCascade(category.getId(), categoryList);
        categoryVO.setChildren(children);
        list.add(categoryVO);
    }));
    return list;
}


public List<CategoryVO> recursionTree(Long parentId,List<PmsCategory> categoryList){
    List<CategoryVO> list = new ArrayList<>();
    Optional.ofNullable(categoryList).ifPresent(categories -> categories.stream().filter(category -> category.getParentId().equals(parentId)).forEach(category -> {
        CategoryVO categoryVO = new CategoryVO();
        BeanUtil.copyProperties(category, categoryVO);
        List<CategoryVO> children = recursionTree(category.getId(), categoryList);
        categoryVO.setChildren(children);
        list.add(categoryVO);
    }));
    return list;
}


}