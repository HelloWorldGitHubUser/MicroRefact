package com.passjava.text;
 import com.passjava.utils.StringUtils;
public class StrFormatter {

 public  String EMPTY_JSON;

 public  char C_BACKSLASH;

 public  char C_DELIM_START;

 public  char C_DELIM_END;


public String format(String strPattern,Object argArray){
    if (StringUtils.isEmpty(strPattern) || StringUtils.isEmpty(argArray)) {
        return strPattern;
    }
    final int strPatternLength = strPattern.length();
    StringBuilder sbuf = new StringBuilder(strPatternLength + 50);
    int handledPosition = 0;
    int delimIndex;
    for (int argIndex = 0; argIndex < argArray.length; argIndex++) {
        delimIndex = strPattern.indexOf(EMPTY_JSON, handledPosition);
        if (delimIndex == -1) {
            if (handledPosition == 0) {
                return strPattern;
            } else {
                sbuf.append(strPattern, handledPosition, strPatternLength);
                return sbuf.toString();
            }
        } else {
            if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == C_BACKSLASH) {
                if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == C_BACKSLASH) {
                    sbuf.append(strPattern, handledPosition, delimIndex - 1);
                    sbuf.append(Convert.utf8Str(argArray[argIndex]));
                    handledPosition = delimIndex + 2;
                } else {
                    argIndex--;
                    sbuf.append(strPattern, handledPosition, delimIndex - 1);
                    sbuf.append(C_DELIM_START);
                    handledPosition = delimIndex + 1;
                }
            } else {
                sbuf.append(strPattern, handledPosition, delimIndex);
                sbuf.append(Convert.utf8Str(argArray[argIndex]));
                handledPosition = delimIndex + 2;
            }
        }
    }
    sbuf.append(strPattern, handledPosition, strPattern.length());
    return sbuf.toString();
}


}