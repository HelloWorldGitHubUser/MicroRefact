package io.bookingmonolith.flight.seats.valueobjects;
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
public class SeatNumber {

 private  String seatNumber;

public SeatNumber(String value) {
    ValidationUtils.notBeNullOrEmpty(value);
    this.seatNumber = value;
}
}