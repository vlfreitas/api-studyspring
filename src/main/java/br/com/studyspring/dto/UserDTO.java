package br.com.studyspring.dto;

import br.com.studyspring.model.Reminder;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String cellphone;
    private List<ReminderDTO> reminders;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String lastName, String email, String cellphone, List<Reminder> reminders) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.reminders = buildReminderDTO(reminders);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<ReminderDTO> getReminders() {
        return reminders;
    }

    public void setReminders(List<ReminderDTO> reminders) {
        this.reminders = reminders;
    }

    public List<ReminderDTO> buildReminderDTO(List<Reminder> reminders){

        List<ReminderDTO> remindersDTO = new ArrayList<>();
        ReminderDTO reminderDTO = new ReminderDTO();

        reminders.forEach(reminder->{
            reminderDTO.setId(reminder.getId());
            reminderDTO.setActive(reminder.isActive());
            reminderDTO.setDays(reminder.getDays());
            reminderDTO.setHour(reminder.getHour());
            remindersDTO.add(reminderDTO);
        });

        return remindersDTO;
    }
}
