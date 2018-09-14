package br.com.studyspring.service;

import br.com.studyspring.dto.ReminderDTO;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ReminderServiceImpl reminderService;

    @Override
    public String sendEmail() {
        try {
            List<ReminderDTO> reminderDTOS = reminderService.getAllReminders();

            String dayOfWeek = getDayOfWeek();
            String hourOfDay = getHourOfDay();

            String result = null;

            if(!reminderDTOS.isEmpty()){
                reminderDTOS.forEach(reminderDTO -> {
                    if(reminderDTO.getDays().contains(dayOfWeek) && reminderDTO.isActive() == true && ){
                        EmailServiceImpl.logger.debug("Day of week: " + dayOfWeek);
                        EmailServiceImpl.logger.debug("Hour of day: " + hourOfDay +  " || Hour of reminder: " + reminderDTO.getHour().toString());
                        if(reminderDTO.getHour().toString().equals(hourOfDay)){
                            SimpleMailMessage message = new SimpleMailMessage();

                            message.setFrom("victormotuca@hotmail.com");
                            message.setTo(reminderDTO.getUserDTO().getEmail());
                            message.setSubject("Spring Boot Application Mail Sender");
                            message.setText("Hello from Spring Boot Application -  Aquele lembrete maroto =)\n" +
                                            "Data: " + dayOfWeek + " / Hora: " + hourOfDay);

                            mailSender.send(message);
                            EmailServiceImpl.logger.debug("Email enviado.");
                        }
                        EmailServiceImpl.logger.debug("Existem email para hoje, mas não para esse horário.");
                    }
                });
                return "OK";
            }
            return "Não existem reminders para hoje";

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }

    private String getDayOfWeek(){

        Locale ptBr = new Locale("pt", "BR");

        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String dayName = dayOfWeek.getDisplayName(TextStyle.FULL, ptBr);
        return dayName;
    }

    private String getHourOfDay(){

        LocalTime localTime = LocalTime.now();
        String hour = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        return hour;
    }
}
