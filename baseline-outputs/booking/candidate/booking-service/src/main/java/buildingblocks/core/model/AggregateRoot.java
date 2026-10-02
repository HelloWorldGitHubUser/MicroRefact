package buildingblocks.core.model;
 import buildingblocks.core.event.DomainEvent;
import lombok;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
public class AggregateRoot extends BaseEntity<T>{

 protected  T id;

 private  CopyOnWriteArrayList<DomainEvent> domainEvents;


public void addDomainEvent(DomainEvent domainEvent){
    domainEvents.add(domainEvent);
}


public void clearDomainEvents(){
    domainEvents.clear();
}


public List<DomainEvent> getDomainEvents(){
    return Collections.unmodifiableList(domainEvents);
}


}