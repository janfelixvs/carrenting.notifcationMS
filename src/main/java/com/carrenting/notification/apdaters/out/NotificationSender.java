package com.carrenting.notification.apdaters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {

    private final SimpMessagingTemplate template;

    @Autowired
    public NotificationSender(SimpMessagingTemplate template) {
        this.template = template;
    }

    /**
     * Send a notification message via WebSocket.
     *
     * @param message The message to be sent.
     */
    public void sendWebSocketNotification(String message) {
        // The destination can be a specific topic or user endpoint
        String destination = "/topic/notifications";

        // Sending the message
        template.convertAndSend(destination, message);
    }
}
