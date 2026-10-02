package com.passjava.utils;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import java.io.Serializable;
import java.util.List;
public class PageUtils implements Serializable{

 private  long serialVersionUID;

 private  int totalCount;

 private  int pageSize;

 private  int totalPage;

 private  int currPage;

 private  List<?> list;

/**
 * 分页
 * @param list        列表数据
 * @param totalCount  总记录数
 * @param pageSize    每页记录数
 * @param currPage    当前页数
 */
public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
    this.list = list;
    this.totalCount = totalCount;
    this.pageSize = pageSize;
    this.currPage = currPage;
    this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
}/**
 * 分页
 */
public PageUtils(IPage<?> page) {
    this.list = page.getRecords();
    this.totalCount = (int) page.getTotal();
    this.pageSize = (int) page.getSize();
    this.currPage = (int) page.getCurrent();
    this.totalPage = (int) page.getPages();
}
public void setTotalCount(int totalCount){
    this.totalCount = totalCount;
}


public int getPageSize(){
    return pageSize;
}


public List<?> getList(){
    return list;
}


public void setTotalPage(int totalPage){
    this.totalPage = totalPage;
}


public void setCurrPage(int currPage){
    this.currPage = currPage;
}


public int getTotalCount(){
    return totalCount;
}


public int getCurrPage(){
    return currPage;
}


public void setList(List<?> list){
    this.list = list;
}


public void setPageSize(int pageSize){
    this.pageSize = pageSize;
}


public int getTotalPage(){
    return totalPage;
}


}