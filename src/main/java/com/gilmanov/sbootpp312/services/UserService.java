package com.gilmanov.sbootpp312.services;

import com.gilmanov.sbootpp312.model.User;
import com.gilmanov.sbootpp312.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void removeUserById(long id) {
        userRepository.delete(getUserById(id));
    }

    public void changeUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
