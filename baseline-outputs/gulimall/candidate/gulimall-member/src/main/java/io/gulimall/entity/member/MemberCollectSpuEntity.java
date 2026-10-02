package io.gulimall.entity.member;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("ums_member_collect_spu")
public class MemberCollectSpuEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long memberId;

 private  Long spuId;

 private  String spuName;

 private  String spuImg;

 private  Date createTime;


}