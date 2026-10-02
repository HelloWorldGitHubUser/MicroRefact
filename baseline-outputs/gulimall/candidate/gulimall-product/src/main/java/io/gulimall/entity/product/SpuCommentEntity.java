package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_spu_comment")
public class SpuCommentEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long skuId;

 private  Long spuId;

 private  String spuName;

 private  String memberNickName;

 private  Integer star;

 private  String memberIp;

 private  Date createTime;

 private  Integer showStatus;

 private  String spuAttributes;

 private  Integer likesCount;

 private  Integer replyCount;

 private  String resources;

 private  String content;

 private  String memberIcon;

 private  Integer commentType;


}