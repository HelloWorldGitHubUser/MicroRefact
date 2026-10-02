package com.passjava.utils;
 import com.passjava.constant.Constants;
import com.passjava.text.StrFormatter;
import org.springframework.util.AntPathMatcher;
import java.util.Collection;
import java.util.List;
import java.util.Map;
public class StringUtils {

 private  String NULLSTR;

 private  char SEPARATOR;


public boolean isNotNull(Object object){
    return !isNull(object);
}


public boolean ishttp(String link){
    return StringUtils.startsWithAny(link, Constants.HTTP, Constants.HTTPS);
}


public T nvl(T value,T defaultValue){
    return value != null ? value : defaultValue;
}


public boolean isEmpty(String str){
    return isNull(str) || NULLSTR.equals(str.trim());
}


public String format(String template,Object params){
    if (isEmpty(params) || isEmpty(template)) {
        return template;
    }
    return StrFormatter.format(template, params);
}


public String toUnderScoreCase(String str){
    if (str == null) {
        return null;
    }
    StringBuilder sb = new StringBuilder();
    boolean preCharIsUpperCase = true;
    boolean curreCharIsUpperCase = true;
    boolean nexteCharIsUpperCase = true;
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (i > 0) {
            preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
        } else {
            preCharIsUpperCase = false;
        }
        curreCharIsUpperCase = Character.isUpperCase(c);
        if (i < (str.length() - 1)) {
            nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
        }
        if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase) {
            sb.append(SEPARATOR);
        } else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase) {
            sb.append(SEPARATOR);
        }
        sb.append(Character.toLowerCase(c));
    }
    return sb.toString();
}


public boolean hasText(String str){
    return (str != null && !str.isEmpty() && containsText(str));
}


public boolean matches(String str,List<String> strs){
    if (isEmpty(str) || isEmpty(strs)) {
        return false;
    }
    for (String pattern : strs) {
        if (isMatch(pattern, str)) {
            return true;
        }
    }
    return false;
}


public boolean isMatch(String pattern,String url){
    AntPathMatcher matcher = new AntPathMatcher();
    return matcher.match(pattern, url);
}


public String substring(String str,int start,int end){
    if (str == null) {
        return NULLSTR;
    }
    if (end < 0) {
        end = str.length() + end;
    }
    if (start < 0) {
        start = str.length() + start;
    }
    if (end > str.length()) {
        end = str.length();
    }
    if (start > end) {
        return NULLSTR;
    }
    if (start < 0) {
        start = 0;
    }
    if (end < 0) {
        end = 0;
    }
    return str.substring(start, end);
}


@SuppressWarnings("unchecked")
public T cast(Object obj){
    return (T) obj;
}


public boolean containsText(CharSequence str){
    int strLen = str.length();
    for (int i = 0; i < strLen; i++) {
        if (!Character.isWhitespace(str.charAt(i))) {
            return true;
        }
    }
    return false;
}


public String trim(String str){
    return (str == null ? "" : str.trim());
}


public boolean isNull(Object object){
    return object == null;
}


public boolean isNotEmpty(String str){
    return !isEmpty(str);
}


public boolean isArray(Object object){
    return isNotNull(object) && object.getClass().isArray();
}


}