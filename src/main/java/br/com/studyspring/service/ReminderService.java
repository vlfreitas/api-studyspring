package br.com.studyspring.service;

import br.com.studyspring.dto.ReminderDTO;
import br.com.studyspring.model.Reminder;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface ReminderService {

    Reminder save(Reminder reminder);

    List<ReminderDTO> getAllReminders();

    Reminder update(Integer id, Reminder reminder);

    HttpStatus delete(Integer id);
}
