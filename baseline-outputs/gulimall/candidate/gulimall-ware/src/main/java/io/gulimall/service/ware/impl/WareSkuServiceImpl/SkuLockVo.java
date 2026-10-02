package io.gulimall.service.ware.impl.WareSkuServiceImpl;
 import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gulimall.exception.NoStockException;
import io.gulimall.vo.SkuHasStockVo;
import io.gulimall.to.mq.OrderTo;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.Query;
import io.gulimall.entity.product.SkuInfoEntity;
import io.gulimall.entity.order.OrderEntity;
import io.gulimall.enume.OrderStatusEnum;
import io.gulimall.service.order.OrderService;
import io.gulimall.service.product.SkuInfoService;
import io.gulimall.dao.ware.WareSkuDao;
import io.gulimall.entity.ware.WareOrderTaskDetailEntity;
import io.gulimall.entity.ware.WareOrderTaskEntity;
import io.gulimall.entity.ware.WareSkuEntity;
import io.gulimall.enume.WareTaskStatusEnum;
import io.gulimall.service.ware.WareOrderTaskDetailService;
import io.gulimall.service.ware.WareOrderTaskService;
import io.gulimall.service.ware.WareSkuService;
import io.gulimall.vo.OrderItemVo;
import io.gulimall.vo.WareSkuLockVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
@Data
public class SkuLockVo {

 private  Long skuId;

 private  Integer num;

 private  List<Long> wareIds;


}