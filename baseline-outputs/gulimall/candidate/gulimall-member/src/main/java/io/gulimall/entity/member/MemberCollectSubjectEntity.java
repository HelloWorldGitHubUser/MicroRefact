package io.gulimall.entity.member;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("ums_member_collect_subject")
public class MemberCollectSubjectEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long subjectId;

 private  String subjectName;

 private  String subjectImg;

 private  String subjectUrll;


}