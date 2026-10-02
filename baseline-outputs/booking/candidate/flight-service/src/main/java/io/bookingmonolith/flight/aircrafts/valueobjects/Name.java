package io.bookingmonolith.flight.aircrafts.valueobjects;
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
public class Name {

 private  String name;

public Name(String value) {
    ValidationUtils.notBeNullOrEmpty(value);
    this.name = value;
}
}