package com.internship.bluebird.controller;


import com.internship.bluebird.dto.User;
import com.internship.bluebird.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User create(@RequestBody User user)
    {
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user)
    {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id)
    {
        userService.delete(id);
    }

    @GetMapping("{id}")
    public User get(@PathVariable Integer id)
    {
        return userService.get(id);
    }

    @GetMapping("/all")
    public List<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/authenticate")
    public boolean checkCreditentials() {
        return true;
    }
}