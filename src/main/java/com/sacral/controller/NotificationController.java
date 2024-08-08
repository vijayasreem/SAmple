package com.sacral.controller;

import com.sacral.model.Notification;
import com.sacral.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/approved")
    public List<Notification> findApprovedNotifications() {
        return notificationService.findApprovedNotifications();
    }

    @GetMapping("/customer/{customerId}")
    public List<Notification> findNotificationsByCustomerId(@PathVariable Long customerId) {
        return notificationService.findNotificationsByCustomerId(customerId);
    }

    // Add more controller methods as needed

}