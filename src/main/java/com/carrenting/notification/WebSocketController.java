package com.carrenting.notification;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/send")
    public void sendMessage(@RequestBody NotificationRequest notificationRequest) {
        String message = notificationRequest.getMessageText();
        // Sendet die Nachricht an das spezifische Thema für diese Kundennummer
        messagingTemplate.convertAndSend("/topic/messages/" + notificationRequest.getCustomerId(), message);
    }

    // Example of handling WebSocket messages
    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public String processMessageFromClient(@Payload String message) throws Exception {
        return message;
    }
}
