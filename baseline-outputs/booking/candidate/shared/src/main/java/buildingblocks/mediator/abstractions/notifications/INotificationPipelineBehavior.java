package buildingblocks.mediator.abstractions.notifications;
 public interface INotificationPipelineBehavior {


public Void handle(TNotification notification,NotificationHandlerDelegate next)
;

}