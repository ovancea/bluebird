package com.internship.bluebird.service;

import com.internship.bluebird.domain.TaskEntity;
import com.internship.bluebird.dto.Task;
import com.internship.bluebird.mapper.TaskMapper;
import com.internship.bluebird.repo.TaskRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepo taskRepo;
    private TaskMapper taskMapper;


    public TaskService(TaskRepo taskRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;

    }

    public Task create(Task task) {
        TaskEntity taskEntity = taskMapper.businessObjectToEntity(task);
        return taskMapper.entityToBusinessObject(taskRepo.save(taskEntity));
    }

    public List<Task> create(List<Task> taskList)
    {
       List<TaskEntity> taskEntityList = taskMapper.businessObjectsToEntities(taskList);
       return taskMapper.entitiesToBusinessObject(taskRepo.saveAll(taskEntityList));
    }

    public Task get(Integer id) {
        Optional<TaskEntity> taskEntityOptional = taskRepo.findById(id);

        if (taskEntityOptional.isPresent()) {

            return taskMapper.entityToBusinessObject(taskEntityOptional.get());
        }

        throw new EntityNotFoundException();
    }

    public List<Task> findByUserStoryId(Integer id) {

        List<Task> taskList = taskMapper.entitiesToBusinessObject(taskRepo.findByUserStoryId(id));

        return taskList;
    }

    public List<Task> findByUserId(Integer id) {

        List<Task> taskList = taskMapper.entitiesToBusinessObject(taskRepo.findByUserId(id));

        return taskList;
    }

    public Task update(Task task) {
        TaskEntity taskEntity = taskMapper.businessObjectToEntity(task);
        return taskMapper.entityToBusinessObject(taskRepo.save(taskEntity));
    }

    public void delete(Integer id) {
        taskRepo.deleteById(id);
    }

    public void deleteByUserStoryId(Integer id)
    {
        taskRepo.deleteByUserStoryId(id);
    }

    public void deleteByUserId(Integer id)
    {
        taskRepo.deleteByUserId(id);
    }
}
