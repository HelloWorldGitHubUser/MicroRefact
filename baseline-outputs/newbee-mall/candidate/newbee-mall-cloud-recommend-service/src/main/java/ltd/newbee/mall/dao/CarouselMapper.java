package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.Carousel;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface CarouselMapper {


public List<Carousel> findCarouselList(PageQueryUtil pageUtil)
;

public Carousel selectByPrimaryKey(Integer carouselId)
;

public int insertSelective(Carousel record)
;

public List<Carousel> findCarouselsByNum(int number)
;

public int updateByPrimaryKeySelective(Carousel record)
;

public int updateByPrimaryKey(Carousel record)
;

public int insert(Carousel record)
;

public int deleteByPrimaryKey(Integer carouselId)
;

public int getTotalCarousels(PageQueryUtil pageUtil)
;

public int deleteBatch(Long[] ids)
;

}