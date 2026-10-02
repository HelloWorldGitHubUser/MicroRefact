package buildingblocks.core.event;
 import com.github.f4b6a3.uuid.UuidCreator;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
public interface IEvent {

 private Map<IEvent,UUID> EVENT_IDS;

 private Map<IEvent,LocalDateTime> EVENT_OCCURRED;


public LocalDateTime getOccurredOn(){
    return EVENT_OCCURRED.computeIfAbsent(this, key -> LocalDateTime.now());
}
;

public String getEventType(){
    return this.getClass().getTypeName();
}
;

public UUID getEventId(){
    return EVENT_IDS.computeIfAbsent(this, key -> UuidCreator.getTimeOrderedEpoch());
}
;

}