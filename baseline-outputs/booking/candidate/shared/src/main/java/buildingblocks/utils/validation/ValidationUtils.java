package buildingblocks.utils.validation;
 import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util;
import java.util.regex.Pattern;
import org.springframework.lang.Nullable;
public class ValidationUtils {

 private  Set<String> ALLOWED_CURRENCIES;

private ValidationUtils() {
    throw new AssertionError("Cannot instantiate utility class.");
}
public T notBeEmpty(T enumValue,String argumentName){
    if (enumValue == null) {
        throw new IllegalArgumentException(argumentName + " cannot be null.");
    }
    return enumValue;
}


public void notBeNegativeOrNull(Number number){
    notBeNullOrEmpty(number);
    // Convert the number to BigDecimal for accurate comparison
    BigDecimal bigDecimalValue = new BigDecimal(number.toString());
    if (bigDecimalValue.compareTo(BigDecimal.ZERO) < 0) {
        throw new IllegalArgumentException("Number cannot be negative.");
    }
}


public String notBeInvalidPhoneNumber(String phoneNumber,String argumentName){
    String phoneRegex = "^[+]?\\d{10,15}$";
    if (!Pattern.matches(phoneRegex, phoneNumber)) {
        throw new IllegalArgumentException(argumentName + " is not a valid phone number.");
    }
    return phoneNumber;
}


public void notBeNullOrEmpty(UUID value){
    if (value == null || value.equals(new UUID(0L, 0L)))
        throw new IllegalArgumentException("Value cannot be empty.");
}


public String notBeInvalidEmail(String email,String argumentName){
    String emailRegex = "^[\\w.-]+@[\\w-]+\\.[a-z]{2,}$";
    if (!Pattern.matches(emailRegex, email)) {
        throw new IllegalArgumentException(argumentName + " is not a valid email address.");
    }
    return email;
}


public T notBeDefault(T enumValue,String argumentName){
    if (enumValue == null || enumValue.ordinal() == 0) {
        throw new IllegalArgumentException(argumentName + " cannot be the default enum value.");
    }
    return enumValue;
}


public void validLocalDateTime(LocalDateTime dateTime){
    if (dateTime == null) {
        throw new IllegalArgumentException("Date and time cannot be null.");
    }
}


public String notBeNullOrWhiteSpace(String argument,String argumentName){
    if (argument == null || argument.trim().isEmpty()) {
        throw new IllegalArgumentException(argumentName + " cannot be null, empty, or whitespace.");
    }
    return argument;
}


public String notBeInvalidCurrency(String currency,String argumentName){
    if (currency == null || !ALLOWED_CURRENCIES.contains(currency.toUpperCase())) {
        throw new IllegalArgumentException(argumentName + " is not a valid currency.");
    }
    return currency;
}


public T notBeNull(T argument,String argumentName){
    if (argument == null) {
        throw new IllegalArgumentException(argumentName + " cannot be null.");
    }
    return argument;
}


public double notBeNegativeOrZero(double argument,String argumentName){
    if (argument <= 0) {
        throw new IllegalArgumentException(argumentName + " must be greater than zero.");
    }
    return argument;
}


}