package com.central.Interface;
public interface IAggregationService {

   public Map<String,Object> getDefaultStatData();
   public Map<String,Object> requestStatAgg(String indexName,String routing);
}