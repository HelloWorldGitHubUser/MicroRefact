package com.youlai.mall.service.pms;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.pms.entity.PmsCategoryAttribute;
import com.youlai.mall.model.pms.form.PmsCategoryAttributeForm;
public interface AttributeService extends IService<PmsCategoryAttribute>{


public boolean saveBatch(PmsCategoryAttributeForm formData)
;

}