package com.central.service;
 import java.io.IOException;
import java.util.Map;
public interface IAggregationService {


public Map<String,Object> getDefaultStatData()
;

public Map<String,Object> requestStatAgg(String indexName,String routing) throws IOException
;

}