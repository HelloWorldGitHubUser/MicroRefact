package com.youlai.mall.config.auth.oauth2.jackson;
 import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.youlai.mall.model.auth.SysUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.io.IOException;
import java.util.Set;
public class SysUserDeserializer extends JsonDeserializer<SysUserDetails>{

 private  TypeReference<Set<SimpleGrantedAuthority>> SIMPLE_GRANTED_AUTHORITY_SET;


public JsonNode readJsonNode(JsonNode jsonNode,String field){
    return jsonNode.has(field) ? jsonNode.get(field) : MissingNode.getInstance();
}


@Override
public SysUserDetails deserialize(JsonParser jp,DeserializationContext ctxt) throws IOException{
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    JsonNode jsonNode = mapper.readTree(jp);
    Set<? extends GrantedAuthority> authorities = mapper.convertValue(jsonNode.get("authorities"), SIMPLE_GRANTED_AUTHORITY_SET);
    JsonNode passwordNode = readJsonNode(jsonNode, "password");
    Long userId = readJsonNode(jsonNode, "userId").asLong();
    String username = readJsonNode(jsonNode, "username").asText();
    String password = passwordNode.asText("");
    Integer dataScope = readJsonNode(jsonNode, "dataScope").asInt();
    Long deptId = readJsonNode(jsonNode, "deptId").asLong();
    boolean enabled = readJsonNode(jsonNode, "enabled").asBoolean();
    boolean accountNonExpired = readJsonNode(jsonNode, "accountNonExpired").asBoolean();
    boolean credentialsNonExpired = readJsonNode(jsonNode, "credentialsNonExpired").asBoolean();
    boolean accountNonLocked = readJsonNode(jsonNode, "accountNonLocked").asBoolean();
    SysUserDetails result = new SysUserDetails(userId, username, password, dataScope, deptId, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    if (passwordNode.asText(null) == null) {
        result.eraseCredentials();
    }
    return result;
}


}