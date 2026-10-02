package com.hoangtien2k3.ecommerce.utils;
 import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
public class MessagesUtils {

 private  ResourceBundle messageBundle;

private MessagesUtils() {
}
public String getMessage(String errorCode,Object var2){
    String message;
    try {
        message = messageBundle.getString(errorCode);
    } catch (MissingResourceException ex) {
        message = errorCode;
    }
    FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, var2);
    return formattingTuple.getMessage();
}


}