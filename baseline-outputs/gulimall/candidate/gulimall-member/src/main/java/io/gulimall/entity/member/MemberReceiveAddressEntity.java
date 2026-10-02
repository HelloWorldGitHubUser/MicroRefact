package io.gulimall.entity.member;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("ums_member_receive_address")
public class MemberReceiveAddressEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long memberId;

 private  String name;

 private  String phone;

 private  String postCode;

 private  String province;

 private  String city;

 private  String region;

 private  String detailAddress;

 private  String areacode;

 private  Integer defaultStatus;


}