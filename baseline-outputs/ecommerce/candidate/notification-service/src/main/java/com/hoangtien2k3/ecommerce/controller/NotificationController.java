package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.model.notification.Notification;
import com.hoangtien2k3.ecommerce.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

 private  NotificationService notificationService;


@PostMapping
public ResponseEntity<Notification> saveNotification(Notification notification){
    Notification savedNotification = notificationService.saveNotification(notification);
    return new ResponseEntity<>(savedNotification, HttpStatus.CREATED);
}


@DeleteMapping("/{id}")
public ResponseEntity<Boolean> deleteNotification(String id){
    notificationService.deleteNotificationById(id);
    return new ResponseEntity<>(true, HttpStatus.OK);
}


@GetMapping
public List<Notification> getAllNotifications(){
    return notificationService.getAllNotifications();
}


@GetMapping("/{id}")
public ResponseEntity<Notification> getNotificationById(String id){
    Optional<Notification> notification = notificationService.getNotificationById(id);
    return notification.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}


}