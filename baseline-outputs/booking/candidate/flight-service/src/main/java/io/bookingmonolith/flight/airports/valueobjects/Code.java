package io.bookingmonolith.flight.airports.valueobjects;
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
public class Code {

 private  String code;

public Code(String value) {
    ValidationUtils.notBeNullOrEmpty(value);
    this.code = value;
}
}