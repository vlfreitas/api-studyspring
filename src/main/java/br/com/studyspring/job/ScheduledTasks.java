package br.com.studyspring.job;

import br.com.studyspring.service.EmailServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private EmailServiceImpl emailService;


    @Scheduled(fixedRate = 60000)
    public void taskSendEmail() {
        try{
            ScheduledTasks.logger.info("Iniciando taskSendEmail({})");

            String result = emailService.sendEmail();
            ScheduledTasks.logger.info(result);
        }catch(Exception e){
            ScheduledTasks.logger.info("Problema na messagem. " + e.getMessage());
        }
    }

}
