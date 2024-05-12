package org.okaru.notification;

public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String message;
    private String sender;

    public NotificationRequest(Integer toCustomerId, String toCustomerEmail, String message, String sender) {
        this.toCustomerId = toCustomerId;
        this.toCustomerEmail = toCustomerEmail;
        this.message = message;
        this.sender = sender;
    }

    public NotificationRequest(){

    }

    public Integer getToCustomerId() {
        return toCustomerId;
    }

    public void setToCustomerId(Integer toCustomerId) {
        this.toCustomerId = toCustomerId;
    }

    public String getToCustomerEmail() {
        return toCustomerEmail;
    }

    public void setToCustomerEmail(String toCustomerEmail) {
        this.toCustomerEmail = toCustomerEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
