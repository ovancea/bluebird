package com.internship.bluebird.service;

import com.internship.bluebird.domain.TaskEntity;
import com.internship.bluebird.dto.Task;
import com.internship.bluebird.mapper.TaskMapper;
import com.internship.bluebird.repo.TaskRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepo taskRepo;
    private TaskMapper taskMapper;
    private UserStoryService userStoryService;

    public TaskService(TaskRepo taskRepo, TaskMapper taskMapper, UserStoryService userStoryService) {
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
        this.userStoryService = userStoryService;
    }

    public Task create(Task task)
    {
        TaskEntity taskEntity = taskMapper.businessObjectToEntity(task);
        taskEntity.setUserStoryId(task.getUserStory().getId());
        return taskMapper.entityToBusinessObject(taskRepo.save(taskEntity));
    }

    public Task get(Integer id)
    {
        Optional<TaskEntity> taskEntityOptional = taskRepo.findById(id);

        if (taskEntityOptional.isPresent()) {

            Task savedTask = taskMapper.entityToBusinessObject(taskEntityOptional.get());
            savedTask.setUserStory(userStoryService.get(taskEntityOptional.get().getUserStoryId()));

            return savedTask;
        }

        throw new EntityNotFoundException();
    }

    public Task update(Task task)
    {
        TaskEntity taskEntity = taskMapper.businessObjectToEntity(task);
        taskEntity.setUserStoryId(task.getUserStory().getId());
        return taskMapper.entityToBusinessObject(taskRepo.save(taskEntity));
    }

    public void delete(Integer id)
    {
        taskRepo.deleteById(id);
    }

}
