package ltd.newbee.mall.api.mall.vo;
 import ltd.newbee.mall.entity.GoodsCategory;
import java.io.Serializable;
import java.util.List;
public class SearchPageCategoryVO implements Serializable{

 private  String firstLevelCategoryName;

 private  List<GoodsCategory> secondLevelCategoryList;

 private  String secondLevelCategoryName;

 private  List<GoodsCategory> thirdLevelCategoryList;

 private  String currentCategoryName;


public List<GoodsCategory> getSecondLevelCategoryList(){
    return secondLevelCategoryList;
}


public void setSecondLevelCategoryName(String secondLevelCategoryName){
    this.secondLevelCategoryName = secondLevelCategoryName;
}


public List<GoodsCategory> getThirdLevelCategoryList(){
    return thirdLevelCategoryList;
}


public void setThirdLevelCategoryList(List<GoodsCategory> thirdLevelCategoryList){
    this.thirdLevelCategoryList = thirdLevelCategoryList;
}


public String getSecondLevelCategoryName(){
    return secondLevelCategoryName;
}


public String getCurrentCategoryName(){
    return currentCategoryName;
}


public void setCurrentCategoryName(String currentCategoryName){
    this.currentCategoryName = currentCategoryName;
}


public String getFirstLevelCategoryName(){
    return firstLevelCategoryName;
}


public void setFirstLevelCategoryName(String firstLevelCategoryName){
    this.firstLevelCategoryName = firstLevelCategoryName;
}


public void setSecondLevelCategoryList(List<GoodsCategory> secondLevelCategoryList){
    this.secondLevelCategoryList = secondLevelCategoryList;
}


}