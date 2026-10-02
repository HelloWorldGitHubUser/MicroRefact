package io.gulimall.xss;
 import java.util;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HTMLFilter {

 private  int REGEX_FLAGS_SI;

 private  Pattern P_COMMENTS;

 private  Pattern P_COMMENT;

 private  Pattern P_TAGS;

 private  Pattern P_END_TAG;

 private  Pattern P_START_TAG;

 private  Pattern P_QUOTED_ATTRIBUTES;

 private  Pattern P_UNQUOTED_ATTRIBUTES;

 private  Pattern P_PROTOCOL;

 private  Pattern P_ENTITY;

 private  Pattern P_ENTITY_UNICODE;

 private  Pattern P_ENCODE;

 private  Pattern P_VALID_ENTITIES;

 private  Pattern P_VALID_QUOTES;

 private  Pattern P_END_ARROW;

 private  Pattern P_BODY_TO_END;

 private  Pattern P_XML_CONTENT;

 private  Pattern P_STRAY_LEFT_ARROW;

 private  Pattern P_STRAY_RIGHT_ARROW;

 private  Pattern P_AMP;

 private  Pattern P_QUOTE;

 private  Pattern P_LEFT_ARROW;

 private  Pattern P_RIGHT_ARROW;

 private  Pattern P_BOTH_ARROWS;

 private  ConcurrentMap<String,Pattern> P_REMOVE_PAIR_BLANKS;

 private  ConcurrentMap<String,Pattern> P_REMOVE_SELF_BLANKS;

 private  Map<String,List<String>> vAllowed;

 private  Map<String,Integer> vTagCounts;

 private  String[] vSelfClosingTags;

 private  String[] vNeedClosingTags;

 private  String[] vDisallowed;

 private  String[] vProtocolAtts;

 private  String[] vAllowedProtocols;

 private  String[] vRemoveBlanks;

 private  String[] vAllowedEntities;

 private  boolean stripComment;

 private  boolean encodeQuotes;

 private  boolean vDebug;

 private  boolean alwaysMakeTags;

/**
 * Default constructor.
 */
public HTMLFilter() {
    vAllowed = new HashMap<>();
    final ArrayList<String> a_atts = new ArrayList<String>();
    a_atts.add("href");
    a_atts.add("target");
    vAllowed.put("a", a_atts);
    final ArrayList<String> img_atts = new ArrayList<String>();
    img_atts.add("src");
    img_atts.add("width");
    img_atts.add("height");
    img_atts.add("alt");
    vAllowed.put("img", img_atts);
    final ArrayList<String> no_atts = new ArrayList<String>();
    vAllowed.put("b", no_atts);
    vAllowed.put("strong", no_atts);
    vAllowed.put("i", no_atts);
    vAllowed.put("em", no_atts);
    vSelfClosingTags = new String[] { "img" };
    vNeedClosingTags = new String[] { "a", "b", "strong", "i", "em" };
    vDisallowed = new String[] {};
    // no ftp.
    vAllowedProtocols = new String[] { "http", "mailto", "https" };
    vProtocolAtts = new String[] { "src", "href" };
    vRemoveBlanks = new String[] { "a", "b", "strong", "i", "em" };
    vAllowedEntities = new String[] { "amp", "gt", "lt", "quot" };
    stripComment = true;
    encodeQuotes = true;
    alwaysMakeTags = true;
}/**
 * Set debug flag to true. Otherwise use default settings. See the default constructor.
 *
 * @param debug turn debug on with a true argument
 */
public HTMLFilter(final boolean debug) {
    this();
    vDebug = debug;
}/**
 * Map-parameter configurable constructor.
 *
 * @param conf map containing configuration. keys match field names.
 */
public HTMLFilter(final Map<String, Object> conf) {
    assert conf.containsKey("vAllowed") : "configuration requires vAllowed";
    assert conf.containsKey("vSelfClosingTags") : "configuration requires vSelfClosingTags";
    assert conf.containsKey("vNeedClosingTags") : "configuration requires vNeedClosingTags";
    assert conf.containsKey("vDisallowed") : "configuration requires vDisallowed";
    assert conf.containsKey("vAllowedProtocols") : "configuration requires vAllowedProtocols";
    assert conf.containsKey("vProtocolAtts") : "configuration requires vProtocolAtts";
    assert conf.containsKey("vRemoveBlanks") : "configuration requires vRemoveBlanks";
    assert conf.containsKey("vAllowedEntities") : "configuration requires vAllowedEntities";
    vAllowed = Collections.unmodifiableMap((HashMap<String, List<String>>) conf.get("vAllowed"));
    vSelfClosingTags = (String[]) conf.get("vSelfClosingTags");
    vNeedClosingTags = (String[]) conf.get("vNeedClosingTags");
    vDisallowed = (String[]) conf.get("vDisallowed");
    vAllowedProtocols = (String[]) conf.get("vAllowedProtocols");
    vProtocolAtts = (String[]) conf.get("vProtocolAtts");
    vRemoveBlanks = (String[]) conf.get("vRemoveBlanks");
    vAllowedEntities = (String[]) conf.get("vAllowedEntities");
    stripComment = conf.containsKey("stripComment") ? (Boolean) conf.get("stripComment") : true;
    encodeQuotes = conf.containsKey("encodeQuotes") ? (Boolean) conf.get("encodeQuotes") : true;
    alwaysMakeTags = conf.containsKey("alwaysMakeTags") ? (Boolean) conf.get("alwaysMakeTags") : true;
}
public String checkTags(String s){
    Matcher m = P_TAGS.matcher(s);
    final StringBuffer buf = new StringBuffer();
    while (m.find()) {
        String replaceStr = m.group(1);
        replaceStr = processTag(replaceStr);
        m.appendReplacement(buf, Matcher.quoteReplacement(replaceStr));
    }
    m.appendTail(buf);
    s = buf.toString();
    // these get tallied in processTag
    // (remember to reset before subsequent calls to filter method)
    for (String key : vTagCounts.keySet()) {
        for (int ii = 0; ii < vTagCounts.get(key); ii++) {
            s += "</" + key + ">";
        }
    }
    return s;
}


public String processRemoveBlanks(String s){
    String result = s;
    for (String tag : vRemoveBlanks) {
        if (!P_REMOVE_PAIR_BLANKS.containsKey(tag)) {
            P_REMOVE_PAIR_BLANKS.putIfAbsent(tag, Pattern.compile("<" + tag + "(\\s[^>]*)?></" + tag + ">"));
        }
        result = regexReplace(P_REMOVE_PAIR_BLANKS.get(tag), "", result);
        if (!P_REMOVE_SELF_BLANKS.containsKey(tag)) {
            P_REMOVE_SELF_BLANKS.putIfAbsent(tag, Pattern.compile("<" + tag + "(\\s[^>]*)?/>"));
        }
        result = regexReplace(P_REMOVE_SELF_BLANKS.get(tag), "", result);
    }
    return result;
}


public String decodeEntities(String s){
    StringBuffer buf = new StringBuffer();
    Matcher m = P_ENTITY.matcher(s);
    while (m.find()) {
        final String match = m.group(1);
        final int decimal = Integer.decode(match).intValue();
        m.appendReplacement(buf, Matcher.quoteReplacement(chr(decimal)));
    }
    m.appendTail(buf);
    s = buf.toString();
    buf = new StringBuffer();
    m = P_ENTITY_UNICODE.matcher(s);
    while (m.find()) {
        final String match = m.group(1);
        final int decimal = Integer.valueOf(match, 16).intValue();
        m.appendReplacement(buf, Matcher.quoteReplacement(chr(decimal)));
    }
    m.appendTail(buf);
    s = buf.toString();
    buf = new StringBuffer();
    m = P_ENCODE.matcher(s);
    while (m.find()) {
        final String match = m.group(1);
        final int decimal = Integer.valueOf(match, 16).intValue();
        m.appendReplacement(buf, Matcher.quoteReplacement(chr(decimal)));
    }
    m.appendTail(buf);
    s = buf.toString();
    s = validateEntities(s);
    return s;
}


public String processTag(String s){
    // ending tags
    Matcher m = P_END_TAG.matcher(s);
    if (m.find()) {
        final String name = m.group(1).toLowerCase();
        if (allowed(name)) {
            if (!inArray(name, vSelfClosingTags)) {
                if (vTagCounts.containsKey(name)) {
                    vTagCounts.put(name, vTagCounts.get(name) - 1);
                    return "</" + name + ">";
                }
            }
        }
    }
    // starting tags
    m = P_START_TAG.matcher(s);
    if (m.find()) {
        final String name = m.group(1).toLowerCase();
        final String body = m.group(2);
        String ending = m.group(3);
        // debug( "in a starting tag, name='" + name + "'; body='" + body + "'; ending='" + ending + "'" );
        if (allowed(name)) {
            String params = "";
            final Matcher m2 = P_QUOTED_ATTRIBUTES.matcher(body);
            final Matcher m3 = P_UNQUOTED_ATTRIBUTES.matcher(body);
            final List<String> paramNames = new ArrayList<String>();
            final List<String> paramValues = new ArrayList<String>();
            while (m2.find()) {
                // ([a-z0-9]+)
                paramNames.add(m2.group(1));
                // (.*?)
                paramValues.add(m2.group(3));
            }
            while (m3.find()) {
                // ([a-z0-9]+)
                paramNames.add(m3.group(1));
                // ([^\"\\s']+)
                paramValues.add(m3.group(3));
            }
            String paramName, paramValue;
            for (int ii = 0; ii < paramNames.size(); ii++) {
                paramName = paramNames.get(ii).toLowerCase();
                paramValue = paramValues.get(ii);
                // debug( "paramName='" + paramName + "'" );
                // debug( "paramValue='" + paramValue + "'" );
                // debug( "allowed? " + vAllowed.get( name ).contains( paramName ) );
                if (allowedAttribute(name, paramName)) {
                    if (inArray(paramName, vProtocolAtts)) {
                        paramValue = processParamProtocol(paramValue);
                    }
                    params += " " + paramName + "=\"" + paramValue + "\"";
                }
            }
            if (inArray(name, vSelfClosingTags)) {
                ending = " /";
            }
            if (inArray(name, vNeedClosingTags)) {
                ending = "";
            }
            if (ending == null || ending.length() < 1) {
                if (vTagCounts.containsKey(name)) {
                    vTagCounts.put(name, vTagCounts.get(name) + 1);
                } else {
                    vTagCounts.put(name, 1);
                }
            } else {
                ending = " /";
            }
            return "<" + name + params + ending + ">";
        } else {
            return "";
        }
    }
    // comments
    m = P_COMMENT.matcher(s);
    if (!stripComment && m.find()) {
        return "<" + m.group() + ">";
    }
    return "";
}


public void debug(String msg){
    if (vDebug) {
        Logger.getAnonymousLogger().info(msg);
    }
}


public String processParamProtocol(String s){
    s = decodeEntities(s);
    final Matcher m = P_PROTOCOL.matcher(s);
    if (m.find()) {
        final String protocol = m.group(1);
        if (!inArray(protocol, vAllowedProtocols)) {
            // bad protocol, turn into local anchor link instead
            s = "#" + s.substring(protocol.length() + 1, s.length());
            if (s.startsWith("#//")) {
                s = "#" + s.substring(3, s.length());
            }
        }
    }
    return s;
}


public boolean allowed(String name){
    return (vAllowed.isEmpty() || vAllowed.containsKey(name)) && !inArray(name, vDisallowed);
}


public String validateEntities(String s){
    StringBuffer buf = new StringBuffer();
    // validate entities throughout the string
    Matcher m = P_VALID_ENTITIES.matcher(s);
    while (m.find()) {
        // ([^&;]*)
        final String one = m.group(1);
        // (?=(;|&|$))
        final String two = m.group(2);
        m.appendReplacement(buf, Matcher.quoteReplacement(checkEntity(one, two)));
    }
    m.appendTail(buf);
    return encodeQuotes(buf.toString());
}


public String regexReplace(Pattern regex_pattern,String replacement,String s){
    Matcher m = regex_pattern.matcher(s);
    return m.replaceAll(replacement);
}


public boolean isValidEntity(String entity){
    return inArray(entity, vAllowedEntities);
}


public String chr(int decimal){
    return String.valueOf((char) decimal);
}


public String htmlSpecialChars(String s){
    String result = s;
    result = regexReplace(P_AMP, "&amp;", result);
    result = regexReplace(P_QUOTE, "&quot;", result);
    result = regexReplace(P_LEFT_ARROW, "&lt;", result);
    result = regexReplace(P_RIGHT_ARROW, "&gt;", result);
    return result;
}


public String filter(String input){
    reset();
    String s = input;
    debug("************************************************");
    debug("              INPUT: " + input);
    s = escapeComments(s);
    debug("     escapeComments: " + s);
    s = balanceHTML(s);
    debug("        balanceHTML: " + s);
    s = checkTags(s);
    debug("          checkTags: " + s);
    s = processRemoveBlanks(s);
    debug("processRemoveBlanks: " + s);
    s = validateEntities(s);
    debug("    validateEntites: " + s);
    debug("************************************************\n\n");
    return s;
}


public boolean isAlwaysMakeTags(){
    return alwaysMakeTags;
}


public String checkEntity(String preamble,String term){
    return ";".equals(term) && isValidEntity(preamble) ? '&' + preamble : "&amp;" + preamble;
}


public boolean isStripComments(){
    return stripComment;
}


public String balanceHTML(String s){
    if (alwaysMakeTags) {
        // 
        // try and form html
        // 
        s = regexReplace(P_END_ARROW, "", s);
        s = regexReplace(P_BODY_TO_END, "<$1>", s);
        s = regexReplace(P_XML_CONTENT, "$1<$2", s);
    } else {
        // 
        // escape stray brackets
        // 
        s = regexReplace(P_STRAY_LEFT_ARROW, "&lt;$1", s);
        s = regexReplace(P_STRAY_RIGHT_ARROW, "$1$2&gt;<", s);
        // 
        // the last regexp causes '<>' entities to appear
        // (we need to do a lookahead assertion so that the last bracket can
        // be used in the next pass of the regexp)
        // 
        s = regexReplace(P_BOTH_ARROWS, "", s);
    }
    return s;
}


public boolean inArray(String s,String[] array){
    for (String item : array) {
        if (item != null && item.equals(s)) {
            return true;
        }
    }
    return false;
}


public void reset(){
    vTagCounts.clear();
}


public String encodeQuotes(String s){
    if (encodeQuotes) {
        StringBuffer buf = new StringBuffer();
        Matcher m = P_VALID_QUOTES.matcher(s);
        while (m.find()) {
            // (>|^)
            final String one = m.group(1);
            // ([^<]+?)
            final String two = m.group(2);
            // (<|$)
            final String three = m.group(3);
            m.appendReplacement(buf, Matcher.quoteReplacement(one + regexReplace(P_QUOTE, "&quot;", two) + three));
        }
        m.appendTail(buf);
        return buf.toString();
    } else {
        return s;
    }
}


public boolean allowedAttribute(String name,String paramName){
    return allowed(name) && (vAllowed.isEmpty() || vAllowed.get(name).contains(paramName));
}


public String escapeComments(String s){
    final Matcher m = P_COMMENTS.matcher(s);
    final StringBuffer buf = new StringBuffer();
    if (m.find()) {
        // (.*?)
        final String match = m.group(1);
        m.appendReplacement(buf, Matcher.quoteReplacement("<!--" + htmlSpecialChars(match) + "-->"));
    }
    m.appendTail(buf);
    return buf.toString();
}


}