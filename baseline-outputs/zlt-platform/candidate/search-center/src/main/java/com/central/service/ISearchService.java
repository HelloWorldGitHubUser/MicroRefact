package com.central.service;
 import com.central.model.dto.LogicDelDto;
import com.central.model.PageResult;
import com.central.model.dto.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
public interface ISearchService {


public PageResult<JsonNode> strQuery(String indexName,SearchDto searchDto,LogicDelDto logicDelDto) throws IOException
;

}