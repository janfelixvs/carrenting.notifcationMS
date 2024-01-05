package com.carrenting.notification.apdaters.out;

import com.carrenting.notification.ports.out.NotificationSenderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class NotificationSender extends TextWebSocketHandler implements NotificationSenderInterface {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    public NotificationSender(@Qualifier("simpMessagingTemplate") SimpMessagingTemplate template) {
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
