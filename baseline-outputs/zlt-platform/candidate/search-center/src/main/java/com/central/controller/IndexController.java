package com.central.controller;
 import com.central.model.dto.IndexDto;
import com.central.model.PageResult;
import com.central.model.Result;
import com.central.service.IIndexService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation;
import java.io.IOException;
import java.util.Map;
import com.central.DTO.Result;
@Slf4j
@RestController
@Tag(name = "索引管理api")
@RequestMapping("/api-search/admin")
public class IndexController {

@Autowired
 private  IIndexService indexService;

@Value("${zlt.elasticsearch.index.show:*}")
 private  String indexShow;


@GetMapping("/index")
@Operation(summary = "索引详情")
public Result<Map<String,Object>> showIndex(String indexName) throws IOException{
    Map<String, Object> result = indexService.show(indexName);
    return Result.succeed(result);
}


@GetMapping("/indices")
@Operation(summary = "索引列表")
public PageResult<Map<String,String>> list(String queryStr) throws IOException{
    // 将逗号分隔的索引列表转换为单个字符串传递（与微服务版本一致）
    return indexService.list(queryStr, indexShow);
}


@PostMapping("/index")
@Operation(summary = "创建索引")
public Result createIndex(IndexDto indexDto) throws IOException{
    if (indexDto.getNumberOfShards() == null) {
        indexDto.setNumberOfShards(1);
    }
    if (indexDto.getNumberOfReplicas() == null) {
        indexDto.setNumberOfReplicas(0);
    }
    boolean success = indexService.create(indexDto);
    return success ? Result.succeed("操作成功") : Result.failed("操作失败");
}


@DeleteMapping("/index")
@Operation(summary = "删除索引")
public Result deleteIndex(String indexName) throws IOException{
    boolean success = indexService.delete(indexName);
    return success ? Result.succeed("操作成功") : Result.failed("操作失败");
}


}