package com.example.demo.resetPasswordRequest.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String toEmail,String subject,String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("branicicalin07@gmail.com");
        helper.setTo(toEmail);
        helper.setText(body,true);
        helper.setSubject(subject);
        javaMailSender.send(message);

        System.out.println("Mail Sent successfully ....");

    }
}
