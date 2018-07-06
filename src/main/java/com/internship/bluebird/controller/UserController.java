package com.internship.bluebird.controller;


import com.internship.bluebird.dto.User;
import com.internship.bluebird.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
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
}