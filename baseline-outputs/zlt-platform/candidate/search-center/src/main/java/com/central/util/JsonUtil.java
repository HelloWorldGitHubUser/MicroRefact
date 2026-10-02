package com.central.util;
 import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JsonUtil {

 private  ObjectMapper objectMapper;


public String toJson(Object obj){
    try {
        return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
        log.error("JSON序列化失败", e);
        return "{}";
    }
}


public JsonNode parse(String json){
    try {
        return objectMapper.readTree(json);
    } catch (JsonProcessingException e) {
        log.error("JSON解析失败", e);
        return objectMapper.createObjectNode();
    }
}


}