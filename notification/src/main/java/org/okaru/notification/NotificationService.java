package org.okaru.notification;

import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Inject
    private NotificationRepository repository;

//    public NotificationService(NotificationRepository repository) {
//        this.repository = repository;
//    }

    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setMessage(notificationRequest.getMessage());
        notification.setToCustomerId(notificationRequest.getToCustomerId());
        notification.setToCustomerEmail(notificationRequest.getToCustomerEmail());
        notification.setSentAt(LocalDateTime.now());
        notification.setSender(notificationRequest.getSender());

        repository.save(notification);

    }
}
