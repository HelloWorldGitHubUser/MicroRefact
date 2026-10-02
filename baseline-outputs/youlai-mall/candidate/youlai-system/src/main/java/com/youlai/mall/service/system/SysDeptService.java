package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.entity.SysDept;
import com.youlai.mall.model.system.form.DeptForm;
import com.youlai.mall.model.system.query.DeptQuery;
import com.youlai.mall.model.system.vo.DeptVO;
import com.youlai.mall.web.model.Option;
import java.util.List;
public interface SysDeptService extends IService<SysDept>{


public List<DeptVO> listDepartments(DeptQuery queryParams)
;

public DeptForm getDeptForm(Long deptId)
;

public Long updateDept(Long deptId,DeptForm formData)
;

public Long saveDept(DeptForm formData)
;

public boolean deleteByIds(String ids)
;

public List<Option> listDeptOptions()
;

}