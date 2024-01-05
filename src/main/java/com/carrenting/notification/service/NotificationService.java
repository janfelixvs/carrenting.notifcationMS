package com.carrenting.notification.service;

import com.carrenting.notification.apdaters.out.NotificationSender;
import com.carrenting.notification.ports.in.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements NotificationManager {

    private final NotificationSender notificationSender;

    @Autowired
    public NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    @Override
    public void sendNotification(String messageText) {
        // Here, use the NotificationSender to send the message via WebSocket
        notificationSender.sendWebSocketNotification(messageText);
    }
}
