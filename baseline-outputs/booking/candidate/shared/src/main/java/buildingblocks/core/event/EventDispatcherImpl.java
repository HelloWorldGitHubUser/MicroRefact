package buildingblocks.core.event;
 import buildingblocks.core.model.AggregateRoot;
import buildingblocks.utils.reflection.ReflectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;
@Component
public class EventDispatcherImpl implements EventDispatcher{

 private  EventMapper eventMapper;

 private  ApplicationEventPublisher applicationEventPublisher;

 private  ApplicationContext applicationContext;

public EventDispatcherImpl(EventMapper eventMapper, ApplicationEventPublisher applicationEventPublisher, ApplicationContext applicationContext) {
    this.eventMapper = eventMapper;
    this.applicationEventPublisher = applicationEventPublisher;
    this.applicationContext = applicationContext;
}
@Override
public void clearDomainEvents(){
    AggregateRoot<?> aggregateRoot = ReflectionUtils.getInstanceOfSubclass(AggregateRoot.class, applicationContext);
    Objects.requireNonNull(aggregateRoot).clearDomainEvents();
}


@Override
public List<DomainEvent> getDomainEvents(){
    AggregateRoot<?> aggregateRoot = ReflectionUtils.getInstanceOfSubclass(AggregateRoot.class, applicationContext);
    return Objects.requireNonNull(aggregateRoot).getDomainEvents();
}


@Override
public void send(List<T> domainEvents,Class<?> eventType){
    List<IntegrationEvent> integrationEvents = domainEvents.stream().map(eventMapper::MapToIntegrationEvent).filter(Objects::nonNull).toList();
    integrationEvents.forEach(applicationEventPublisher::publishEvent);
}


}