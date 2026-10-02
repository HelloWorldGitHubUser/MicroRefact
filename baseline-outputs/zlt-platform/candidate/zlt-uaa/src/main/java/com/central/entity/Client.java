package com.central.entity;
 import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oauth_client_details")
public class Client extends SuperEntity{

 private  long serialVersionUID;

 private  String clientId;

 private  String clientName;

 private  String resourceIds;

 private  String clientSecret;

 private  String clientSecretStr;

 private  String scope;

 private  String authorizedGrantTypes;

 private  String webServerRedirectUri;

 private  String authorities;

@TableField(value = "access_token_validity")
 private  Integer accessTokenValiditySeconds;

@TableField(value = "refresh_token_validity")
 private  Integer refreshTokenValiditySeconds;

 private  String additionalInformation;

 private  String autoapprove;

 private  String tokenFormat;

 private  Long creatorId;


}