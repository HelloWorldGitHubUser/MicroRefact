package com.lakesidemutual.interfaces.converters;
 import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.lakesidemutual.domain.policy.PolicyId;
@Component
public class StringToPolicyIdConverter implements Converter<String, PolicyId>{


@Override
public PolicyId convert(String source){
    return new PolicyId(source);
}


}