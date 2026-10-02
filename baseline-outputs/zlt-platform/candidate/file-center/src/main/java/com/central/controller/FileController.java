package com.central.controller;
 import com.central.entity.FileInfo;
import com.central.model.PageResult;
import com.central.model.Result;
import com.central.service.IFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation;
import org.springframework.web.multipart.MultipartFile;
import jakarta.annotation.Resource;
import java.util.Map;
import com.central.DTO.Result;
@Tag(name = "文件管理")
@RestController
@RequestMapping("/api-file")
public class FileController {

@Resource
 private  IFileService fileService;


@GetMapping("/files")
@Operation(summary = "文件列表")
public PageResult<FileInfo> findFiles(Map<String,Object> params){
    return fileService.findList(params);
}


@PostMapping("/files-anon")
@Operation(summary = "文件上传")
public FileInfo upload(MultipartFile file) throws Exception{
    return fileService.upload(file);
}


@DeleteMapping("/files/{id}")
@Operation(summary = "文件删除")
public Result delete(String id){
    try {
        fileService.delete(id);
        return Result.succeed("操作成功");
    } catch (Exception ex) {
        return Result.failed("操作失败");
    }
}


}