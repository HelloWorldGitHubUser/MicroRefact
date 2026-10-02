package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.model.notification.Notification;
import java.util.List;
import java.util.Optional;
public interface NotificationService {


public Notification saveNotification(Notification notification)
;

public void deleteNotificationById(String id)
;

public List<Notification> getAllNotifications()
;

public Optional<Notification> getNotificationById(String id)
;

}