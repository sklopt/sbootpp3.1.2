package com.gilmanov.sbootpp312.services;

import com.gilmanov.sbootpp312.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void removeUserById(long id);

    void changeUser(User user);

    User getUserById(long id);
}
