package io.gulimall.entity.product;
 import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
@TableName("pms_comment_replay")
public class CommentReplayEntity implements Serializable{

 private  long serialVersionUID;

@TableId
 private  Long id;

 private  Long commentId;

 private  Long replyId;


}