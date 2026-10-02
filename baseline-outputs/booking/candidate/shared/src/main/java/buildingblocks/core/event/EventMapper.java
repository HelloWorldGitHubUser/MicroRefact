package buildingblocks.core.event;
 public interface EventMapper {


public InternalCommand MapToInternalCommand(DomainEvent event)
;

public IntegrationEvent MapToIntegrationEvent(DomainEvent event)
;

}