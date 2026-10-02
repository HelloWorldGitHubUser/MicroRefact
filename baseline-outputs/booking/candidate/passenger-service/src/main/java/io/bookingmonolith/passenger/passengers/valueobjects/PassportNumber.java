package io.bookingmonolith.passenger.passengers.valueobjects;
 import buildingblocks.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Embeddable
@EqualsAndHashCode
// Required by JPA
@NoArgsConstructor
@Getter
public class PassportNumber {

 private  String passportNumber;

public PassportNumber(String value) {
    ValidationUtils.notBeNullOrEmpty(value);
    this.passportNumber = value;
}
}