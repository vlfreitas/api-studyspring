package br.com.studyspring.service;

import br.com.studyspring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Override
    public void save(User user) {

    }

    @Override
    public User findByUserName(String username) {
        return null;
    }
}
