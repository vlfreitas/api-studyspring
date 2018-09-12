package br.com.studyspring.controller;

import br.com.studyspring.model.User;
import br.com.studyspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> create(@RequestBody User user) {
        try {
            if(user.getName().isEmpty()){
                return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {

        try {
            if(id != null){
                userRepository.deleteById(id);
                return new ResponseEntity<User>(HttpStatus.OK);
            }
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            throw e;
        }

    }
}
