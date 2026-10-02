package com.youlai.mall.service.pms.impl;
 import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.mall.constant.ProductConstants;
import com.youlai.mall.converter.SkuConverter;
import com.youlai.mall.mapper.PmsSkuMapper;
import com.youlai.mall.model.pms.dto.LockSkuDTO;
import com.youlai.mall.model.pms.dto.SkuInfoDTO;
import com.youlai.mall.model.pms.entity.PmsSku;
import com.youlai.mall.service.pms.SkuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class SkuServiceImpl extends ServiceImpl<PmsSkuMapper, PmsSku>implements SkuService{

 private  RedisTemplate redisTemplate;

 private  SkuConverter skuConverter;


@Override
@Transactional
public boolean lockStock(String orderToken,List<LockSkuDTO> lockSkuList){
    log.info("订单({})锁定商品库存：{}", orderToken, JSONUtil.toJsonStr(lockSkuList));
    Assert.isTrue(CollectionUtil.isNotEmpty(lockSkuList), "订单({})未包含任何商品", orderToken);
    // 校验库存数量是否足够以及锁定库存
    for (LockSkuDTO lockedSku : lockSkuList) {
        // 订单的商品数量
        Integer quantity = lockedSku.getQuantity();
        // 库存足够
        boolean lockResult = this.update(new LambdaUpdateWrapper<PmsSku>().setSql(// 修改锁定商品数
        "locked_stock = locked_stock + " + quantity).eq(PmsSku::getId, lockedSku.getSkuId()).apply("stock - locked_stock >= {0}", // 剩余商品数 ≥ 订单商品数
        quantity));
        Assert.isTrue(lockResult, "商品库存不足");
    }
    // 锁定的商品缓存至 Redis (后续使用：1.取消订单解锁库存；2：支付订单扣减库存)
    redisTemplate.opsForValue().set(ProductConstants.LOCKED_SKUS_PREFIX + orderToken, lockSkuList);
    return true;
}


@Override
@Transactional
public boolean deductStock(String orderSn){
    // 获取订单提交时锁定的商品
    List<LockSkuDTO> lockedSkus = (List<LockSkuDTO>) redisTemplate.opsForValue().get(ProductConstants.LOCKED_SKUS_PREFIX + orderSn);
    log.info("订单({})支付成功，扣减订单商品库存：{}", orderSn, JSONUtil.toJsonStr(lockedSkus));
    Assert.isTrue(CollectionUtil.isNotEmpty(lockedSkus), "扣减商品库存失败：订单({})未包含商品");
    for (LockSkuDTO lockedSku : lockedSkus) {
        boolean deductResult = this.update(new LambdaUpdateWrapper<PmsSku>().setSql("stock = stock - " + lockedSku.getQuantity()).setSql("locked_stock = locked_stock - " + lockedSku.getQuantity()).eq(PmsSku::getId, lockedSku.getSkuId()));
        Assert.isTrue(deductResult, "扣减商品库存失败");
    }
    // 移除订单锁定的商品
    redisTemplate.delete(ProductConstants.LOCKED_SKUS_PREFIX + orderSn);
    return true;
}


@Override
public SkuInfoDTO getSkuInfo(Long skuId){
    return this.baseMapper.getSkuInfo(skuId);
}


@Override
public List<SkuInfoDTO> listSkuInfos(List<Long> skuIds){
    List<PmsSku> list = this.list(new LambdaQueryWrapper<PmsSku>().in(PmsSku::getId, skuIds));
    return skuConverter.entity2SkuInfoDto(list);
}


@Override
@Transactional
public boolean unlockStock(String orderSn){
    List<LockSkuDTO> lockedSkus = (List<LockSkuDTO>) redisTemplate.opsForValue().get(ProductConstants.LOCKED_SKUS_PREFIX + orderSn);
    log.info("释放订单({})锁定的商品库存:{}", orderSn, JSONUtil.toJsonStr(lockedSkus));
    // 库存已释放
    if (CollectionUtil.isEmpty(lockedSkus)) {
        return true;
    }
    // 解锁商品库存
    for (LockSkuDTO lockedSku : lockedSkus) {
        boolean unlockResult = this.update(new LambdaUpdateWrapper<PmsSku>().setSql("locked_stock = locked_stock - " + lockedSku.getQuantity()).eq(PmsSku::getId, lockedSku.getSkuId()));
        Assert.isTrue(unlockResult, "解锁商品库存失败");
    }
    // 移除 redis 订单锁定的商品
    redisTemplate.delete(ProductConstants.LOCKED_SKUS_PREFIX + orderSn);
    return true;
}


}