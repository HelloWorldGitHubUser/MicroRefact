package com.central.trace;
 import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import org.slf4j.MDC;
import java.util.concurrent.atomic.AtomicInteger;
public class MDCTraceUtils {

 public  String KEY_TRACE_ID;

 public  String KEY_SPAN_ID;

 public  String TRACE_ID_HEADER;

 public  String SPAN_ID_HEADER;

 public  int FILTER_ORDER;

 private  TransmittableThreadLocal<AtomicInteger> spanNumber;


public String createTraceId(){
    return IdUtil.getSnowflake().nextIdStr();
}


public void putTrace(String traceId,String spanId){
    MDC.put(KEY_TRACE_ID, traceId);
    MDC.put(KEY_SPAN_ID, spanId);
    initSpanNumber();
}


public void removeTrace(){
    MDC.remove(KEY_TRACE_ID);
    MDC.remove(KEY_SPAN_ID);
    spanNumber.remove();
}


public String getTraceId(){
    return MDC.get(KEY_TRACE_ID);
}


public String getSpanId(){
    return MDC.get(KEY_SPAN_ID);
}


public String getNextSpanId(){
    return StrUtil.format("{}.{}", getSpanId(), spanNumber.get().incrementAndGet());
}


public void initSpanNumber(){
    spanNumber.set(new AtomicInteger(0));
}


public void addTrace(){
    String traceId = createTraceId();
    MDC.put(KEY_TRACE_ID, traceId);
    MDC.put(KEY_SPAN_ID, "0");
    initSpanNumber();
}


}