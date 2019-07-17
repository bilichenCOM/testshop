package com.bilichenko.mvc.testshop.service;

public interface MailService {

    void sendMessage(String to, String topic, String content);
}
