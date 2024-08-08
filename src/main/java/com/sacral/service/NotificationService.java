package com.sacral.service;

import com.sacral.model.Notification;
import com.sacral.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findApprovedNotifications() {
        return notificationRepository.findApprovedNotifications();
    }

    public List<Notification> findNotificationsByCustomerId(Long customerId) {
        return notificationRepository.findNotificationsByCustomerId(customerId);
    }

    // Add more business methods as needed

}