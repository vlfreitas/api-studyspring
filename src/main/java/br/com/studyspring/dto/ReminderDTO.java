package br.com.studyspring.dto;

import br.com.studyspring.model.User;

import java.time.LocalTime;

public class ReminderDTO {


    private Integer id;
    private boolean active;
    private LocalTime hour;
    private String days;
    private UserDTO userDTO;

    public ReminderDTO() { }

    public ReminderDTO(Integer id, boolean active, LocalTime hour, String days, User user) {
        this.id = id;
        this.active = active;
        this.hour = hour;
        this.days = days;
        this.userDTO = buildUserDTO(user);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO buildUserDTO(User user){

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCellphone(user.getCellphone());

        return userDTO;
    }
}
