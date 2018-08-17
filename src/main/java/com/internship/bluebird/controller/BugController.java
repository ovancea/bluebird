package com.internship.bluebird.controller;


import com.internship.bluebird.dto.Bug;
import com.internship.bluebird.service.BugService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bug")
public class BugController {

    private BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }


    @PostMapping
    public Bug create(@RequestBody Bug bug)
    {
        return bugService.create(bug);
    }

    @PutMapping
    public Bug update(@RequestBody Bug bug)
    {
        return bugService.update(bug);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id)
    {
        bugService.delete(id);
    }

    @GetMapping("{id}")
    public Bug get(@PathVariable Integer id)
    {
        return bugService.get(id);
    }


}