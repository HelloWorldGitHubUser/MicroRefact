package io.gulimall.service.ware;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.ware.WareInfoEntity;
import io.gulimall.vo.FareVo;
import java.util.Map;
public interface WareInfoService extends IService<WareInfoEntity>{


public FareVo getFare(Long addrId)
;

public PageUtils queryPage(Map<String,Object> params)
;

}