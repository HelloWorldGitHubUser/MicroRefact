package com.central.Interface;
public interface ISearchService {

   public PageResult<JsonNode> strQuery(String indexName,SearchDto searchDto,LogicDelDto logicDelDto);
}