package io.bookingmonolith.flight.data.jpa.seeds;
 import com.github.f4b6a3.uuid.UuidCreator;
import io.bookingmonolith.flight.aircrafts.valueobjects.AircraftId;
import io.bookingmonolith.flight.aircrafts.valueobjects.ManufacturingYear;
import io.bookingmonolith.flight.aircrafts.valueobjects.Model;
import io.bookingmonolith.flight.airports.valueobjects.Address;
import io.bookingmonolith.flight.airports.valueobjects.AirportId;
import io.bookingmonolith.flight.airports.valueobjects.Code;
import io.bookingmonolith.flight.airports.valueobjects.Name;
import io.bookingmonolith.flight.data.jpa.entities.AircraftEntity;
import io.bookingmonolith.flight.data.jpa.entities.AirportEntity;
import io.bookingmonolith.flight.data.jpa.entities.FlightEntity;
import io.bookingmonolith.flight.data.jpa.entities.SeatEntity;
import io.bookingmonolith.flight.flights.enums.FlightStatus;
import io.bookingmonolith.flight.flights.valueobjects;
import io.bookingmonolith.flight.seats.enums.SeatClass;
import io.bookingmonolith.flight.seats.enums.SeatType;
import io.bookingmonolith.flight.seats.valueobjects.FlightId;
import io.bookingmonolith.flight.seats.valueobjects.SeatNumber;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class InitialData {

 public  List<FlightEntity> flights;

 public  List<AirportEntity> airports;

 public  List<AircraftEntity> aircrafts;

 public  List<SeatEntity> seats;


}