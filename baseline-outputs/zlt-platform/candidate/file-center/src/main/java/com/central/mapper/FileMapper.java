package com.central.mapper;
 import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FileMapper extends SuperMapper<FileInfo>{


public List<FileInfo> findList(Page<FileInfo> page,Map<String,Object> params)
;

}