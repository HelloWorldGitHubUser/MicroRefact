package com.youlai.mall.controller;
 import com.youlai.mall.result.Result;
import com.youlai.mall.model.system.vo.FileInfoVO;
import com.youlai.mall.service.system.OssService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation;
import org.springframework.web.multipart.MultipartFile;
import com.youlai.mall.DTO.Result;
@Tag(name = "06.文件接口")
@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileController {

 private  OssService ossService;


@DeleteMapping
@Operation(summary = "文件删除")
public Result deleteFile(String filePath){
    boolean result = ossService.deleteFile(filePath);
    return Result.judge(result);
}


@PostMapping
@Operation(summary = "文件上传")
public Result<FileInfoVO> uploadFile(MultipartFile file){
    FileInfoVO fileInfo = ossService.uploadFile(file);
    return Result.success(fileInfo);
}


}