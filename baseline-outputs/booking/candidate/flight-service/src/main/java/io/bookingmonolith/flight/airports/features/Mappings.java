package io.bookingmonolith.flight.airports.features;
 import com.github.f4b6a3.uuid.UuidCreator;
import io.bookingmonolith.flight.airports.dtos.AirportDto;
import io.bookingmonolith.flight.airports.features.createairport.CreateAirportCommand;
import io.bookingmonolith.flight.airports.features.createairport.CreateAirportRequestDto;
import io.bookingmonolith.flight.airports.models.Airport;
import io.bookingmonolith.flight.data.jpa.entities.AirportEntity;
public class Mappings {


public AirportDto toAirportDto(AirportEntity airportEntity){
    return new AirportDto(airportEntity.getId(), airportEntity.getName().getName(), airportEntity.getCode().getCode(), airportEntity.getAddress().getAddress());
}


public AirportEntity toAirportEntity(Airport airport){
    return new AirportEntity(airport.getId().getAirportId(), airport.getName(), airport.getCode(), airport.getAddress(), airport.getCreatedAt(), airport.getCreatedBy(), airport.getLastModified(), airport.getLastModifiedBy(), airport.getVersion(), airport.isDeleted());
}


public CreateAirportCommand toCreateAirportCommand(CreateAirportRequestDto createAirportRequestDto){
    return new CreateAirportCommand(UuidCreator.getTimeOrderedEpoch(), createAirportRequestDto.name(), createAirportRequestDto.code(), createAirportRequestDto.address());
}


}