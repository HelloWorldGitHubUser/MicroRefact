package com.central.controller;
 import com.central.entity.Client;
import com.central.model.PageResult;
import com.central.model.Result;
import com.central.service.IClientService;
import com.google.common.collect.Maps;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation;
import java.util.List;
import java.util.Map;
@Tag(name = "应用管理")
@RestController
@RequestMapping("/api-uaa/clients")
@RequiredArgsConstructor
public class ClientController {

 private  IClientService clientService;


@GetMapping("/{id}")
@Operation(summary = "根据id获取应用")
public Client get(Long id){
    return clientService.getById(id);
}


@GetMapping("/all")
@Operation(summary = "所有应用")
public Result<List<Client>> allClient(){
    PageResult<Client> page = clientService.listClient(Maps.newHashMap(), false);
    return Result.succeed(page.getData());
}


@GetMapping("/list")
@Operation(summary = "应用列表")
public PageResult<Client> list(Map<String,Object> params){
    return clientService.listClient(params, true);
}


@DeleteMapping("/{id}")
@Operation(summary = "删除应用")
public Result<String> delete(Long id){
    clientService.delClient(id);
    return Result.succeed("删除成功");
}


@PostMapping("/saveOrUpdate")
@Operation(summary = "保存或者修改应用")
public Result<String> saveOrUpdate(Client client) throws Exception{
    clientService.saveClient(client);
    return Result.succeed("操作成功");
}


}