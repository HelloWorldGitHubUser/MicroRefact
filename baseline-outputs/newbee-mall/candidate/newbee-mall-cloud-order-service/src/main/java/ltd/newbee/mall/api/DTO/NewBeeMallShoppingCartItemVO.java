package ltd.newbee.mall.api.DTO;
 import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
public class NewBeeMallShoppingCartItemVO implements Serializable{

 private  Long cartItemId;

 private  Long goodsId;

 private  Integer goodsCount;

 private  String goodsName;

 private  String goodsCoverImg;

 private  Integer sellingPrice;


}