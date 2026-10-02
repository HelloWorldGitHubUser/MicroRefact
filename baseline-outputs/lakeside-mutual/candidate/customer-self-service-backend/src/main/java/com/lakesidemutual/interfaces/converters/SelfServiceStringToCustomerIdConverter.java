package com.lakesidemutual.interfaces.converters;
 import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.lakesidemutual.domain.customer.CustomerId;
@Component
public class SelfServiceStringToCustomerIdConverter implements Converter<String, CustomerId>{


@Override
public CustomerId convert(String source){
    return new CustomerId(source);
}


}