package io.gulimall.entity.member;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("ums_member_login_log")
public class MemberLoginLogEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long memberId;

 private  Date createTime;

 private  String ip;

 private  String city;

 private  Integer loginType;


}