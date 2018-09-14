package br.com.studyspring.controller;

import br.com.studyspring.dto.ReminderDTO;
import br.com.studyspring.model.Reminder;
import br.com.studyspring.service.ReminderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/reminders")
public class ReminderController {

    @Autowired
    private ReminderServiceImpl reminderService;

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reminder> create(@RequestBody Reminder reminder) {
        try {
            if(reminder == null){
                return new ResponseEntity<Reminder>(HttpStatus.BAD_REQUEST);
            }
            reminderService.save(reminder);
            return new ResponseEntity<Reminder>( HttpStatus.CREATED);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping()
    public List<ReminderDTO> getAllReminders() {
        try{
            return reminderService.getAllReminders();
        }catch(Exception e){
            throw e;
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Reminder> update(@PathVariable("id") Integer id, Reminder reminderDetails){
        try{
            return new ResponseEntity<Reminder>(reminderService.update(id, reminderDetails), HttpStatus.OK);
        }catch(Exception e){
            throw e;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Reminder> delete(@PathVariable("id") Integer id) {

        try {
            if(id != null){
                return new ResponseEntity<Reminder>(reminderService.delete(id));
            }
            return new ResponseEntity<Reminder>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            throw e;
        }

    }
}
