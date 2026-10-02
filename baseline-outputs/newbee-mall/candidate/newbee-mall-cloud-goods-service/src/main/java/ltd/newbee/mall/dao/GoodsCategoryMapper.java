package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface GoodsCategoryMapper {


public GoodsCategory selectByPrimaryKey(Long categoryId)
;

public int insertSelective(GoodsCategory record)
;

public int getTotalGoodsCategories(PageQueryUtil pageUtil)
;

public int updateByPrimaryKeySelective(GoodsCategory record)
;

public int updateByPrimaryKey(GoodsCategory record)
;

public int insert(GoodsCategory record)
;

public int deleteByPrimaryKey(Long categoryId)
;

public List<GoodsCategory> findGoodsCategoryList(PageQueryUtil pageUtil)
;

public GoodsCategory selectByLevelAndName(Byte categoryLevel,String categoryName)
;

public int deleteBatch(Long[] ids)
;

public List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds,int categoryLevel,int number)
;

}