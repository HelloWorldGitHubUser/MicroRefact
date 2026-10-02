package com.central.service;
 import com.central.model.dto.IndexDto;
import com.central.model.PageResult;
import java.io.IOException;
import java.util.Map;
public interface IIndexService {


public Map<String,Object> show(String indexName) throws IOException
;

public boolean create(IndexDto indexDto) throws IOException
;

public PageResult<Map<String,String>> list(String queryStr,String indices) throws IOException
;

public boolean delete(String indexName) throws IOException
;

}