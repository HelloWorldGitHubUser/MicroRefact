package com.passjava.text;
 import com.passjava.utils.StringUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
public class CharsetKit {

 public  String ISO_8859_1;

 public  String UTF_8;

 public  String GBK;

 public  Charset CHARSET_ISO_8859_1;

 public  Charset CHARSET_UTF_8;

 public  Charset CHARSET_GBK;


public Charset charset(String charset){
    return StringUtils.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset);
}


public String systemCharset(){
    return Charset.defaultCharset().name();
}


public String convert(String source,Charset srcCharset,Charset destCharset){
    if (null == srcCharset) {
        srcCharset = StandardCharsets.ISO_8859_1;
    }
    if (null == destCharset) {
        destCharset = StandardCharsets.UTF_8;
    }
    if (StringUtils.isEmpty(source) || srcCharset.equals(destCharset)) {
        return source;
    }
    return new String(source.getBytes(srcCharset), destCharset);
}


}