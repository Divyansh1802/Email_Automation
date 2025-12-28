package com.EmailAutomation.EmailService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Data
@RequiredArgsConstructor
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
    private String lastotp;

    @Value("${spring.mail.username}")
    private String username;

    public String ConfirmationMail(String email) {
        try {
            String otp=String.format("%05d",new Random().nextInt(10000));

            this.lastotp=otp;

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(username);
            message.setTo(email);
            message.setSubject("OTP Confirmation");
            message.setText("Your OTP is "+lastotp);
            mailSender.send(message);

            return lastotp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void send_AI_Mail(String from,String to, String subject, String content) {
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(username);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            message.setCc(from);
            mailSender.send(message);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
