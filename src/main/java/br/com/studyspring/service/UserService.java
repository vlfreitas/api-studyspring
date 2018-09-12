package br.com.studyspring.service;

import br.com.studyspring.model.User;

public interface UserService {
    void save(User user);

    User findByUserName(String username);
}
