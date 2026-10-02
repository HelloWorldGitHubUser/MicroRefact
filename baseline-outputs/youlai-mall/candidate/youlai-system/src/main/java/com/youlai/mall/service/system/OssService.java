package com.youlai.mall.service.system;
 import com.youlai.mall.model.system.vo.FileInfoVO;
import org.springframework.web.multipart.MultipartFile;
public interface OssService {


public boolean deleteFile(String filePath)
;

public FileInfoVO uploadFile(MultipartFile file)
;

}