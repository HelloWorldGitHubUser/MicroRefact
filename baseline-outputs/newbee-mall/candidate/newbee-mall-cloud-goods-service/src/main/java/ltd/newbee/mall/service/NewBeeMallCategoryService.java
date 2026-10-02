package ltd.newbee.mall.service;
 import ltd.newbee.mall.api.mall.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import java.util.List;
public interface NewBeeMallCategoryService {


public PageResult getCategorisPage(PageQueryUtil pageUtil)
;

public String saveCategory(GoodsCategory goodsCategory)
;

public GoodsCategory getGoodsCategoryById(Long id)
;

public String updateGoodsCategory(GoodsCategory goodsCategory)
;

public List<NewBeeMallIndexCategoryVO> getCategoriesForIndex()
;

public Boolean deleteBatch(Long[] ids)
;

public List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds,int categoryLevel)
;

}