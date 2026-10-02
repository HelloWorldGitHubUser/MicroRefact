package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.IndexConfig;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface IndexConfigMapper {


public IndexConfig selectByTypeAndGoodsId(int configType,Long goodsId)
;

public int getTotalIndexConfigs(PageQueryUtil pageUtil)
;

public IndexConfig selectByPrimaryKey(Long configId)
;

public int insertSelective(IndexConfig record)
;

public List<IndexConfig> findIndexConfigsByTypeAndNum(int configType,int number)
;

public int updateByPrimaryKeySelective(IndexConfig record)
;

public int updateByPrimaryKey(IndexConfig record)
;

public int insert(IndexConfig record)
;

public int deleteByPrimaryKey(Long configId)
;

public List<IndexConfig> findIndexConfigList(PageQueryUtil pageUtil)
;

public int deleteBatch(Long[] ids)
;

}