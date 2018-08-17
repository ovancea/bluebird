package com.internship.bluebird.controller;

import com.internship.bluebird.dto.UserStory;
import com.internship.bluebird.service.UserStoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/userstory")
public class UserStoryController {

    private UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }


    @PostMapping
    public UserStory create(@RequestBody UserStory userStory)
    {
        return userStoryService.create(userStory);
    }

    @PutMapping
    public UserStory update(@RequestBody UserStory userStory)
    {
        return userStoryService.update(userStory);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id)
    {
        userStoryService.delete(id);
    }

    @GetMapping("{id}")
    public UserStory get(@PathVariable Integer id)
    {
        return userStoryService.get(id);
    }

    @GetMapping("/all")
    public List<UserStory> getAll()
    {
        return userStoryService.getAll();
    }
}
