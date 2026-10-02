package com.central.service;
 import com.central.entity.FileInfo;
import com.central.model.PageResult;
import org.springframework.web.multipart.MultipartFile;
import java.io.OutputStream;
import java.util.Map;
public interface IFileService extends ISuperService<FileInfo>{


public FileInfo upload(MultipartFile file) throws Exception
;

public PageResult<FileInfo> findList(Map<String,Object> params)
;

public void delete(String id)
;

public void out(String id,OutputStream os)
;

}