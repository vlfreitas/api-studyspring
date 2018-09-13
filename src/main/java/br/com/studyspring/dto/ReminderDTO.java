package br.com.studyspring.dto;

import java.time.LocalTime;

public class RemainderDTO {


    private Long id;
    private boolean active;
    private LocalTime hour;
    private String days;

    public RemainderDTO(Long id, boolean active, LocalTime hour, String days) {
        this.id = id;
        this.active = active;
        this.hour = hour;
        this.days = days;
    }

    public RemainderDTO() {
    }

    //private UserDTO userDTO;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
