package br.com.studyspring.service;

import br.com.studyspring.dto.ReminderDTO;
import br.com.studyspring.model.Reminder;
import br.com.studyspring.model.User;
import br.com.studyspring.repository.ReminderRepository;
import br.com.studyspring.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderServiceImpl implements ReminderService {

    private static final Logger logger = LogManager.getLogger(ReminderServiceImpl.class);

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Reminder save(Reminder reminder) {

        try{
            Optional<User> user = userRepository.findById(reminder.getUser().getId());
            reminder.setUser(user.get());
            reminderRepository.save(reminder);
            return reminder;
        }catch(Exception e){
            ReminderServiceImpl.logger.info(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ReminderDTO> getAllReminders() {
        try{
            return reminderRepository.find();
        }catch(Exception e){
            ReminderServiceImpl.logger.info(e.getMessage());
            throw e;
        }
    }

    @Override
    public Reminder update(Integer id, Reminder reminder) {
        try{
            Optional<User> user = userRepository.findById(reminder.getUser().getId());
            reminder.setUser(user.get());
            return reminder;
        }catch(Exception e){
            ReminderServiceImpl.logger.info(e.getMessage());
            throw e;
        }
    }



    @Override
    public HttpStatus delete(Integer id) {
        try{
            reminderRepository.deleteById(id);
            return HttpStatus.NO_CONTENT;
        }catch(Exception e){
            ReminderServiceImpl.logger.info(e.getMessage());
            throw e;
        }

    }
}
