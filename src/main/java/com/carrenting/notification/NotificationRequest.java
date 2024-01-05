package com.carrenting.notification;

public class NotificationRequest {
    private int customerId;
    private String messageText;

    // Konstruktoren, Getter und Setter
    public NotificationRequest() {}

    public NotificationRequest(int customerId, String messageText) {
        this.customerId = customerId;
        this.messageText = messageText;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
