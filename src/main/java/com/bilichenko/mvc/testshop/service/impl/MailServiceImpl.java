package com.bilichenko.mvc.testshop.service.impl;

import com.bilichenko.mvc.testshop.service.MailService;
import com.bilichenko.mvc.testshop.utils.MailServiceConfigurer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailServiceConfigurer configurer;

    private static final Logger logger = Logger.getLogger(MailServiceImpl.class);

    @Override
    public void sendMessage(String to, String topic, String content) {

        Session session = Session.getInstance(configurer.getMailProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(configurer.getUsername(), configurer.getPassword());
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(configurer.getFrom()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(topic);
            message.setText(content);

            Transport.send(message);

            logger.info("Message successfully send to address " + to);

        } catch (MessagingException e) {
            logger.warn("sending message failed. " + e.getMessage());
        }
    }

}