package br.com.studyspring.service;

import br.com.studyspring.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User save(User user);

    User delete(User user);

    User update(User user);

    User findByUserName(String username);

    User findRemindersByUserId(Integer id);
}
