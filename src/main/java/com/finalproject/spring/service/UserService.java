package com.finalproject.spring.service;

import com.finalproject.spring.model.NoSuchUserException;
import com.finalproject.spring.model.User;
import com.finalproject.spring.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws NoSuchUserException {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new NoSuchUserException("User with specified ID doesn't exist in table"));
    }
}
