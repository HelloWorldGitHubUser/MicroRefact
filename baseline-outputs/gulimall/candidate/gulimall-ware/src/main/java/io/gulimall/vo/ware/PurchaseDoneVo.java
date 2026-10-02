package io.gulimall.vo.ware;
 import lombok.Data;
import java.util.List;
@Data
public class PurchaseDoneVo {

 private  Long id;

 private  List<PurchaseDoneItemVo> items;


}