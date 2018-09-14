package br.com.studyspring.controller;

import br.com.studyspring.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping(path = "/email-send")
    public String sendMail() {

        try{
            String result = emailService.sendEmail();
            return result;
        }catch(Exception e){
            throw e;
        }

    }
}
