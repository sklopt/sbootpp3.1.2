package com.gilmanov.sbootpp312.controllers;

import com.gilmanov.sbootpp312.model.User;
import com.gilmanov.sbootpp312.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users2", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/users/save")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "saveUser";
    }

    @PostMapping(value = "/users/save")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/change/{id}")
    public String editUser(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "changeUser";
    }

    @PatchMapping(value = "users/change")
    public String edit(@ModelAttribute("user") User user) {
        userService.changeUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("users/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
