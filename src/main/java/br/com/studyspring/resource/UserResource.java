package br.com.studyspring.resource;

import br.com.studyspring.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private List<User> users;

    public UserResource() {
        users = new ArrayList<>();

        User u1 = new User(1, "Victor");
        User u2 = new User(2, "Higor");

        users.add(u1);
        users.add(u2);
    }

    @GetMapping("/all")
    public List<User> list(){
        return users;
    }
}
