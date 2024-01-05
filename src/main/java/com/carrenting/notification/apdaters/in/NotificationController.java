package com.carrenting.notification.apdaters.in;

import com.carrenting.notification.ports.in.NotificationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final NotificationManager notificationManager;

    public NotificationController(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String messageText) {
        // Assuming there's a method in NotificationManager to send a message
        notificationManager.sendNotification(messageText);
        return ResponseEntity.ok("Message sent successfully");
    }
}
