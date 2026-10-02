package com.hoangtien2k3.ecommerce.utils;
 import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DateTimeUtils {

 private  String DEFAULT_PATTERN;

private DateTimeUtils() {
}
public String format(LocalDateTime dateTime,String pattern){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return dateTime.format(formatter);
}


}