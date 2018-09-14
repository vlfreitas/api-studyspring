package br.com.studyspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setText("Hello from Spring Boot Application");
        message.setTo("victormotuca@hotmail.com");
        message.setFrom("victormotuca@hotmail.com");
        message.setSubject("Spring Boot Application Mail Sender");

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}
