package com.goodskill.util;
 import com.goodskill.enums.CommonConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
public class HeaderUtil {


public String getUserId(){
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (attributes != null) {
        HttpServletRequest request = attributes.getRequest();
        return request.getHeader(CommonConstants.USER_ID_HEADER);
    }
    return "";
}


}