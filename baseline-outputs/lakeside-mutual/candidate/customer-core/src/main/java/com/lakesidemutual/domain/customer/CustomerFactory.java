package com.lakesidemutual.domain.customer;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.lakesidemutual.infrastructure.CustomerRepository;
import org.microserviceapipatterns.domaindrivendesign.Factory;
@Component
public class CustomerFactory implements Factory{

@Autowired
 private  CustomerRepository customerRepository;


public String formatPhoneNumber(String phoneNumberStr){
    PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    try {
        PhoneNumber phoneNumber = phoneUtil.parse(phoneNumberStr, "CH");
        return phoneUtil.format(phoneNumber, PhoneNumberFormat.NATIONAL);
    } catch (NumberParseException e) {
        throw new AssertionError();
    }
}


public CustomerAggregateRoot create(CustomerProfileEntity customerProfile){
    CustomerId id = customerRepository.nextId();
    customerProfile.setPhoneNumber(formatPhoneNumber(customerProfile.getPhoneNumber()));
    return new CustomerAggregateRoot(id, customerProfile);
}


}