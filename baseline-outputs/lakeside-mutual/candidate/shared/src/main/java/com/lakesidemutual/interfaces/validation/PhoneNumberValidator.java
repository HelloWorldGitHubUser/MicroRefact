package com.lakesidemutual.interfaces.validation;
 import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String>{

 private  Logger logger;


@Override
public boolean isValid(String phoneNumberStr,ConstraintValidatorContext context){
    PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    try {
        Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(phoneNumberStr, "CH");
        return phoneUtil.isValidNumber(phoneNumber);
    } catch (NumberParseException e) {
        logger.info("'" + phoneNumberStr + "' is not a valid phone number.", e);
        return false;
    }
}


}