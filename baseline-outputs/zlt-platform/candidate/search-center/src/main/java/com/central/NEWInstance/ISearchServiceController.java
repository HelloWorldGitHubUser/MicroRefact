package com.central.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ISearchServiceController {

 private ISearchService isearchservice;


@GetMapping
("/strQuery")
public PageResult<JsonNode> strQuery(@RequestParam(name = "indexName") String indexName,@RequestParam(name = "searchDto") SearchDto searchDto,@RequestParam(name = "logicDelDto") LogicDelDto logicDelDto){
  return isearchservice.strQuery(indexName,searchDto,logicDelDto);
}


}