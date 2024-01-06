package com.carrenting.notification.apdapter.in;

import com.carrenting.notification.dto.NotificationRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;



    //http://localhost:8085/send
    //{
    //    "customerId": 1,
    //    "messageText": "This is a message."
    //}

    @PostMapping("/send")
    public void sendMessage(@RequestBody NotificationRequest notificationRequest) {
        String message = notificationRequest.getMessageText();
        messagingTemplate.convertAndSend("/topic/messages/" + notificationRequest.getCustomerId(), message);
    }


}
