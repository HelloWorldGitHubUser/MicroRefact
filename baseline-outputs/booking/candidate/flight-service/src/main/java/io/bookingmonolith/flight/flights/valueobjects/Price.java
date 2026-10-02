package io.bookingmonolith.flight.flights.valueobjects;
 import buildingblocks.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
@Embeddable
@EqualsAndHashCode
// Required by JPA
@NoArgsConstructor
@Getter
public class Price {

 private  BigDecimal price;

public Price(BigDecimal value) {
    ValidationUtils.notBeNegativeOrNull(value);
    this.price = value;
}
}