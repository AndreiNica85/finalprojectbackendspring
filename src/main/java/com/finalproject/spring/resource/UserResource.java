package com.finalproject.spring.resource;

import com.finalproject.spring.model.NoSuchUserException;
import com.finalproject.spring.model.User;
import com.finalproject.spring.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) throws NoSuchUserException {
        return userService.getUser(id);
    }
}
