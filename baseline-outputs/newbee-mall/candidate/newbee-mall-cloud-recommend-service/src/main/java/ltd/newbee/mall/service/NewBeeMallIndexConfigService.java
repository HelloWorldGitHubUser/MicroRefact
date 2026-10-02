package ltd.newbee.mall.service;
 import ltd.newbee.mall.api.mall.vo.NewBeeMallIndexConfigGoodsVO;
import ltd.newbee.mall.entity.IndexConfig;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import java.util.List;
public interface NewBeeMallIndexConfigService {


public PageResult getConfigsPage(PageQueryUtil pageUtil)
;

public List<NewBeeMallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType,int number)
;

public String updateIndexConfig(IndexConfig indexConfig)
;

public String saveIndexConfig(IndexConfig indexConfig)
;

public Boolean deleteBatch(Long[] ids)
;

public IndexConfig getIndexConfigById(Long id)
;

}