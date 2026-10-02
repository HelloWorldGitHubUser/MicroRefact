package com.youlai.mall.service.pms;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.web.model.Option;
import com.youlai.mall.model.pms.entity.PmsCategory;
import com.youlai.mall.model.pms.vo.CategoryVO;
import java.util.List;
public interface CategoryService extends IService<PmsCategory>{


public List<CategoryVO> getCategoryList(Long parentId)
;

public List<Option> getCategoryOptions()
;

public Long saveCategory(PmsCategory category)
;

}