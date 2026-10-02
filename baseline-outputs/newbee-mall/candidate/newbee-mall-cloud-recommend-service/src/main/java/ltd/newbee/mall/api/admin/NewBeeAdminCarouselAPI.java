package ltd.newbee.mall.api.admin;
 import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ltd.newbee.mall.api.admin.param.BatchIdParam;
import ltd.newbee.mall.api.admin.param.CarouselAddParam;
import ltd.newbee.mall.api.admin.param.CarouselEditParam;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.config.annotation.TokenToAdminUser;
import ltd.newbee.mall.entity.AdminUserToken;
import ltd.newbee.mall.entity.Carousel;
import ltd.newbee.mall.service.NewBeeMallCarouselService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@RestController
@Api(value = "v1", tags = "8-1.后台管理系统轮播图模块接口")
@RequestMapping("/manage-api/v1")
public class NewBeeAdminCarouselAPI {

 private  Logger logger;

@Resource
 private NewBeeMallCarouselService newBeeMallCarouselService;


@RequestMapping(value = "/carousels", method = RequestMethod.POST)
@ApiOperation(value = "新增轮播图", notes = "新增轮播图")
public Result save(CarouselAddParam carouselAddParam,AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    Carousel carousel = new Carousel();
    BeanUtil.copyProperties(carouselAddParam, carousel);
    String result = newBeeMallCarouselService.saveCarousel(carousel);
    if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
        return ResultGenerator.genSuccessResult();
    } else {
        return ResultGenerator.genFailResult(result);
    }
}


@RequestMapping(value = "/carousels", method = RequestMethod.PUT)
@ApiOperation(value = "修改轮播图信息", notes = "修改轮播图信息")
public Result update(CarouselEditParam carouselEditParam,AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    Carousel carousel = new Carousel();
    BeanUtil.copyProperties(carouselEditParam, carousel);
    String result = newBeeMallCarouselService.updateCarousel(carousel);
    if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
        return ResultGenerator.genSuccessResult();
    } else {
        return ResultGenerator.genFailResult(result);
    }
}


@RequestMapping(value = "/carousels", method = RequestMethod.GET)
@ApiOperation(value = "轮播图列表", notes = "轮播图列表")
public Result list(Integer pageNumber,Integer pageSize,AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    if (pageNumber == null || pageNumber < 1 || pageSize == null || pageSize < 10) {
        return ResultGenerator.genFailResult("分页参数异常！");
    }
    Map params = new HashMap(4);
    params.put("page", pageNumber);
    params.put("limit", pageSize);
    PageQueryUtil pageUtil = new PageQueryUtil(params);
    return ResultGenerator.genSuccessResult(newBeeMallCarouselService.getCarouselPage(pageUtil));
}


@RequestMapping(value = "/carousels", method = RequestMethod.DELETE)
@ApiOperation(value = "批量删除轮播图信息", notes = "批量删除轮播图信息")
public Result delete(BatchIdParam batchIdParam,AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    if (batchIdParam == null || batchIdParam.getIds().length < 1) {
        return ResultGenerator.genFailResult("参数异常！");
    }
    if (newBeeMallCarouselService.deleteBatch(batchIdParam.getIds())) {
        return ResultGenerator.genSuccessResult();
    } else {
        return ResultGenerator.genFailResult("删除失败");
    }
}


@RequestMapping(value = "/carousels/{id}", method = RequestMethod.GET)
@ApiOperation(value = "获取单条轮播图信息", notes = "根据id查询")
public Result info(Integer id,AdminUserToken adminUser){
    logger.info("adminUser:{}", adminUser.toString());
    Carousel carousel = newBeeMallCarouselService.getCarouselById(id);
    if (carousel == null) {
        return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
    }
    return ResultGenerator.genSuccessResult(carousel);
}


}