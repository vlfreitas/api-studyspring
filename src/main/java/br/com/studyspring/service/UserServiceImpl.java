package br.com.studyspring.service;

import br.com.studyspring.model.User;
import br.com.studyspring.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findByUserName(String username) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findRemindersByUserId(Integer id) {

//        try{
////            User user = userRepository.findRemindersByUserId(id);
////            return user;
//        }catch(Exception e){
//            throw e;
//        }

        return null;
    }

}
