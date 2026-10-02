package io.gulimall.service.ware;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.ware.PurchaseEntity;
import io.gulimall.vo.ware.MergeVo;
import io.gulimall.vo.ware.PurchaseDoneVo;
import java.util.List;
import java.util.Map;
public interface PurchaseService extends IService<PurchaseEntity>{


public void ReceivedPurchase(List<Long> ids)
;

public void mergePurchaseDetail(MergeVo mergeVo)
;

public void finishPurchase(PurchaseDoneVo purchaseDoneVo)
;

public PageUtils queryPage(Map<String,Object> params)
;

public PageUtils listUnreceive(Map<String,Object> params)
;

}