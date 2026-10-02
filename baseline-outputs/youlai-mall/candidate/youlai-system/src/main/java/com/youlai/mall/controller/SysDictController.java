package com.youlai.mall.controller;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youlai.mall.result.PageResult;
import com.youlai.mall.result.Result;
import com.youlai.mall.web.annotation.PreventDuplicateResubmit;
import com.youlai.mall.model.system.form.DictForm;
import com.youlai.mall.model.system.form.DictTypeForm;
import com.youlai.mall.model.system.query.DictPageQuery;
import com.youlai.mall.model.system.query.DictTypePageQuery;
import com.youlai.mall.model.system.vo.DictPageVO;
import com.youlai.mall.model.system.vo.DictTypePageVO;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.service.system.SysDictService;
import com.youlai.mall.service.system.SysDictTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation;
import java.util.List;
import com.youlai.mall.DTO.PageResult;
@Tag(name = "05.字典接口")
@RestController
@RequestMapping("/api/v1/dict")
@RequiredArgsConstructor
public class SysDictController {

 private  SysDictService dictService;

 private  SysDictTypeService dictTypeService;


@Operation(summary = "字典数据表单数据")
@GetMapping("/{id}/form")
public Result<DictForm> getDictForm(Long id){
    DictForm formData = dictService.getDictForm(id);
    return Result.success(formData);
}


@Operation(summary = "删除字典类型")
@DeleteMapping("/types/{ids}")
@PreAuthorize("@ss.hasPerm('sys:dict_type:delete')")
public Result deleteDictTypes(String ids){
    boolean result = dictTypeService.deleteDictTypes(ids);
    return Result.judge(result);
}


@Operation(summary = "字典类型分页列表")
@GetMapping("/types/page")
public PageResult<DictTypePageVO> getDictTypePage(DictTypePageQuery queryParams){
    Page<DictTypePageVO> result = dictTypeService.getDictTypePage(queryParams);
    return PageResult.success(result);
}


@Operation(summary = "获取字典类型的数据项")
@GetMapping("/types/{typeCode}/items")
public Result<List<Option>> listDictTypeItems(String typeCode){
    List<Option> list = dictTypeService.listDictItemsByTypeCode(typeCode);
    return Result.success(list);
}


@Operation(summary = "修改字典类型")
@PutMapping("/types/{id}")
@PreAuthorize("@ss.hasPerm('sys:dict_type:edit')")
public Result updateDictType(Long id,DictTypeForm dictTypeForm){
    boolean status = dictTypeService.updateDictType(id, dictTypeForm);
    return Result.judge(status);
}


@Operation(summary = "删除字典")
@DeleteMapping("/{ids}")
@PreAuthorize("@ss.hasPerm('sys:dict:delete')")
public Result deleteDict(String ids){
    boolean result = dictService.deleteDict(ids);
    return Result.judge(result);
}


@Operation(summary = "修改字典")
@PutMapping("/{id}")
@PreAuthorize("@ss.hasPerm('sys:dict:edit')")
public Result updateDict(Long id,DictForm DictForm){
    boolean status = dictService.updateDict(id, DictForm);
    return Result.judge(status);
}


@Operation(summary = "字典下拉列表")
@GetMapping("/options")
public Result<List<Option>> listDictOptions(String typeCode){
    List<Option> list = dictService.listDictOptions(typeCode);
    return Result.success(list);
}


@Operation(summary = "新增字典类型")
@PostMapping("/types")
@PreAuthorize("@ss.hasPerm('sys:dict_type:add')")
@PreventDuplicateResubmit
public Result saveDictType(DictTypeForm dictTypeForm){
    boolean result = dictTypeService.saveDictType(dictTypeForm);
    return Result.judge(result);
}


@Operation(summary = "字典类型表单数据")
@GetMapping("/types/{id}/form")
public Result<DictTypeForm> getDictTypeForm(Long id){
    DictTypeForm dictTypeForm = dictTypeService.getDictTypeForm(id);
    return Result.success(dictTypeForm);
}


@Operation(summary = "新增字典")
@PostMapping
@PreAuthorize("@ss.hasPerm('sys:dict:add')")
@PreventDuplicateResubmit
public Result saveDict(DictForm DictForm){
    boolean result = dictService.saveDict(DictForm);
    return Result.judge(result);
}


@Operation(summary = "字典分页列表")
@GetMapping("/page")
public PageResult<DictPageVO> getDictPage(DictPageQuery queryParams){
    Page<DictPageVO> result = dictService.getDictPage(queryParams);
    return PageResult.success(result);
}


}