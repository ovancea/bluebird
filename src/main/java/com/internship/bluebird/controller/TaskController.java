package com.internship.bluebird.controller;


import com.internship.bluebird.dto.Task;
import com.internship.bluebird.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public Task create(@RequestBody Task task)
    {
        return taskService.create(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task)
    {
        return taskService.update(task);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id)
    {
        taskService.delete(id);
    }

    @GetMapping("{id}")
    public Task get(@PathVariable Integer id)
    {
        return taskService.get(id);
    }
}