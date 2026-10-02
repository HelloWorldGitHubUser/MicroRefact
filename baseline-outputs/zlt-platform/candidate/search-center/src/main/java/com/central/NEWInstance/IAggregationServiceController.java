package com.central.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class IAggregationServiceController {

 private IAggregationService iaggregationservice;


@GetMapping
("/getDefaultStatData")
public Map<String,Object> getDefaultStatData(){
  return iaggregationservice.getDefaultStatData();
}


@GetMapping
("/requestStatAgg")
public Map<String,Object> requestStatAgg(@RequestParam(name = "indexName") String indexName,@RequestParam(name = "routing") String routing){
  return iaggregationservice.requestStatAgg(indexName,routing);
}


}