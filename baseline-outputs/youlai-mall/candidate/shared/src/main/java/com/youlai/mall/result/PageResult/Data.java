package com.youlai.mall.result.PageResult;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import java.io.Serializable;
import java.util.List;
@lombok.Data
public class Data {

 private  List<T> list;

 private  long total;


}