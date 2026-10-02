package com.central.mapper;
 import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.central.entity.Client;
@Mapper
public interface ClientMapper extends SuperMapper<Client>{


public List<Client> findList(Page<Client> page,Map<String,Object> params)
;

}