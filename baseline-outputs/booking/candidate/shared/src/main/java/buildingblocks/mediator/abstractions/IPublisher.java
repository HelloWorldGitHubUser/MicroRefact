package buildingblocks.mediator.abstractions;
 import buildingblocks.mediator.abstractions.notifications.INotification;
public interface IPublisher {


public Void publish(TNotification notification) throws Exception
;

}