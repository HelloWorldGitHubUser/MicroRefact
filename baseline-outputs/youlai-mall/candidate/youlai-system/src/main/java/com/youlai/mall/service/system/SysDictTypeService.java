package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.entity.SysDictType;
import com.youlai.mall.model.system.form.DictTypeForm;
import com.youlai.mall.model.system.query.DictTypePageQuery;
import com.youlai.mall.model.system.vo.DictTypePageVO;
import com.youlai.mall.web.model.Option;
import java.util.List;
public interface SysDictTypeService extends IService<SysDictType>{


public boolean deleteDictTypes(String idsStr)
;

public Page<DictTypePageVO> getDictTypePage(DictTypePageQuery queryParams)
;

public boolean updateDictType(Long id,DictTypeForm dictTypeForm)
;

public List<Option> listDictItemsByTypeCode(String typeCode)
;

public boolean saveDictType(DictTypeForm dictTypeForm)
;

public DictTypeForm getDictTypeForm(Long id)
;

}