package com.lakesidemutual.DTO;
 import java.util.List;
public class Page {

 private  List<T> elements;

 private  int offset;

 private  int limit;

 private  int size;

public Page(List<T> elements, int offset, int limit, int size) {
    this.elements = elements;
    this.offset = offset;
    this.limit = limit;
    this.size = size;
}
public int getSize(){
    return size;
}


public int getLimit(){
    return limit;
}


public List<T> getElements(){
    return elements;
}


public int getOffset(){
    return offset;
}


}