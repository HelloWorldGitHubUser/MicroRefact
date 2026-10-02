package ltd.newbee.mall.util.BeanUtil;
 import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util;
public interface Callback {


public void set(Object source,T target)
;

}