package io.bookingmonolith.flight.airports.valueobjects;
 import buildingblocks.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;
@Embeddable
@EqualsAndHashCode
// Required by JPA
@NoArgsConstructor
@Getter
public class AirportId {

 private  UUID airportId;

public AirportId(UUID value) {
    ValidationUtils.notBeNullOrEmpty(value);
    this.airportId = value;
}
}