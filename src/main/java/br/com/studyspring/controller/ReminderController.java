package br.com.studyspring.controller;

import br.com.studyspring.model.Reminder;
import br.com.studyspring.model.User;
import br.com.studyspring.repository.ReminderRepository;
import br.com.studyspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reminders")
public class ReminderController {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reminder> create(@RequestBody Reminder reminder) {
        try {
            if(reminder.equals(null)){
                return new ResponseEntity<Reminder>(HttpStatus.BAD_REQUEST);
            }
            User user = userRepository.findById(reminder.getUser().getId());
            reminder.setUser(user);
            return new ResponseEntity<Reminder>(reminderRepository.save(reminder), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping(path = "/all")
    public Iterable<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Reminder> delete(@PathVariable Long id) {

        try {
            if(id != null){
                reminderRepository.deleteById(id);
                return new ResponseEntity<Reminder>(HttpStatus.OK);
            }
            return new ResponseEntity<Reminder>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            throw e;
        }

    }
}
