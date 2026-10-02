package io.bookingmonolith.flight.aircrafts.features;
 import com.github.f4b6a3.uuid.UuidCreator;
import io.bookingmonolith.flight.aircrafts.dtos.AircraftDto;
import io.bookingmonolith.flight.aircrafts.features.createaircraft.CreateAircraftCommand;
import io.bookingmonolith.flight.aircrafts.features.createaircraft.CreateAircraftRequestDto;
import io.bookingmonolith.flight.aircrafts.models.Aircraft;
import io.bookingmonolith.flight.data.jpa.entities.AircraftEntity;
public class Mappings {


public AircraftEntity toAircraftEntity(Aircraft aircraft){
    return new AircraftEntity(aircraft.getId().getAircraftId(), aircraft.getName(), aircraft.getModel(), aircraft.getManufacturingYear(), aircraft.getCreatedAt(), aircraft.getCreatedBy(), aircraft.getLastModified(), aircraft.getLastModifiedBy(), aircraft.getVersion(), aircraft.isDeleted());
}


public AircraftDto toAircraftDto(AircraftEntity aircraftEntity){
    return new AircraftDto(aircraftEntity.getId(), aircraftEntity.getName().getName(), aircraftEntity.getModel().getModel(), aircraftEntity.getManufacturingYear().getManufacturingYear());
}


public CreateAircraftCommand toCreateAircraftCommand(CreateAircraftRequestDto createAircraftRequestDto){
    return new CreateAircraftCommand(UuidCreator.getTimeOrderedEpoch(), createAircraftRequestDto.name(), createAircraftRequestDto.model(), createAircraftRequestDto.manufacturingYear());
}


}