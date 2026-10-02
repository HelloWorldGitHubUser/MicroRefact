package com.passjava.text;
 import com.passjava.utils.StringUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.NumberFormat;
public class Convert {


public String toStr(Object value){
    return toStr(value, null);
}


public String str(ByteBuffer data,Charset charset){
    if (null == charset) {
        charset = Charset.defaultCharset();
    }
    return charset.decode(data).toString();
}


public Integer toInt(Object value){
    return toInt(value, null);
}


public String utf8Str(Object obj){
    return str(obj, CharsetKit.CHARSET_UTF_8);
}


public Long toLong(Object value){
    return toLong(value, null);
}


public Boolean toBool(Object value){
    return toBool(value, null);
}


}