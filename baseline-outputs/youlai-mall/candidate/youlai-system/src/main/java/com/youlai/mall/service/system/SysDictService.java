package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.entity.SysDict;
import com.youlai.mall.model.system.form.DictForm;
import com.youlai.mall.model.system.query.DictPageQuery;
import com.youlai.mall.model.system.vo.DictPageVO;
import com.youlai.mall.web.model.Option;
import java.util.List;
public interface SysDictService extends IService<SysDict>{


public DictForm getDictForm(Long id)
;

public boolean deleteDict(String idsStr)
;

public boolean updateDict(Long id,DictForm dictForm)
;

public List<Option> listDictOptions(String typeCode)
;

public boolean saveDict(DictForm dictForm)
;

public Page<DictPageVO> getDictPage(DictPageQuery queryParams)
;

}