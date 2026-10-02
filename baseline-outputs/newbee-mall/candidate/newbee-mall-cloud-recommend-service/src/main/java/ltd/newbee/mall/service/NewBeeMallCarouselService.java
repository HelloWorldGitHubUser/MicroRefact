package ltd.newbee.mall.service;
 import ltd.newbee.mall.api.mall.vo.NewBeeMallIndexCarouselVO;
import ltd.newbee.mall.entity.Carousel;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import java.util.List;
public interface NewBeeMallCarouselService {


public PageResult getCarouselPage(PageQueryUtil pageUtil)
;

public List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(int number)
;

public String updateCarousel(Carousel carousel)
;

public Carousel getCarouselById(Integer id)
;

public String saveCarousel(Carousel carousel)
;

public Boolean deleteBatch(Long[] ids)
;

}