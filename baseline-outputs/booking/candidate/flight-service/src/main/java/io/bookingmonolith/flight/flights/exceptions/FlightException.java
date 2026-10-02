package io.bookingmonolith.flight.flights.exceptions;
 import buildingblocks.core.exception.BadRequestException;
public class FlightException extends BadRequestException{

public FlightException(String message) {
    super(message);
}
public FlightException departureBeforeArrival(String departureDate,String arriveDate){
    return new FlightException("Departure date: '" + departureDate + "' must be before arrive date: '" + arriveDate + "'.");
}


public FlightException invalidFlightDate(String flightDate){
    return new FlightException("Flight date: '" + flightDate + "' must be between departure and arrive dates.");
}


}