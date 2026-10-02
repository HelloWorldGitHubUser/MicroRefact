package buildingblocks.core.event;
 import java.util.List;
public interface EventDispatcher {


public void clearDomainEvents()
;

public List<DomainEvent> getDomainEvents()
;

public void send(List<T> domainEvents,Class<?> eventType)
;

}