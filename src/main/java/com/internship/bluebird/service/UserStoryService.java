package com.internship.bluebird.service;

import com.internship.bluebird.domain.UserStoryEntity;
import com.internship.bluebird.dto.UserStory;
import com.internship.bluebird.mapper.UserStoryMapper;
import com.internship.bluebird.repo.UserStoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserStoryService {

    private UserStoryRepo userStoryRepo;
    private UserStoryMapper userStoryMapper;
    private TaskService taskService;
    private BugService bugService;

    @Autowired
    public UserStoryService(UserStoryRepo userStoryRepo, UserStoryMapper userStoryMapper, TaskService taskService, BugService bugService) {
        this.userStoryRepo = userStoryRepo;
        this.userStoryMapper = userStoryMapper;
        this.taskService = taskService;
        this.bugService = bugService;
    }


    @Transactional
    public UserStory create(UserStory userStory)
    {
        UserStoryEntity userStoryEntity = userStoryRepo.save(userStoryMapper.businessObjectToEntity(userStory));
        UserStory savedUserStory = userStoryMapper.entityToBusinessObject(userStoryEntity);

        if(!CollectionUtils.isEmpty(userStory.getTaskList()))
        {
            userStory.getTaskList().forEach(task -> task.setUserStoryId(savedUserStory.getId()));
            savedUserStory.setTaskList(taskService.create(userStory.getTaskList()));
        }

        if(!CollectionUtils.isEmpty(userStory.getBugList()))
        {
            userStory.getBugList().forEach(bug -> bug.setUserStoryId(savedUserStory.getId()));
            savedUserStory.setBugList(bugService.create(userStory.getBugList()));
        }

        return savedUserStory;

    }

@Transactional
    public UserStory get(Integer id){
        Optional<UserStoryEntity> userStoryEntityOptional = userStoryRepo.findById(id);

        if (userStoryEntityOptional.isPresent()) {
            UserStory savedUserStory = userStoryMapper.entityToBusinessObject(userStoryEntityOptional.get());
            savedUserStory.setTaskList(taskService.findByUserStoryId(id));
            savedUserStory.setBugList(bugService.findByUserStoryId(id));
            return savedUserStory;
        }

        throw new EntityNotFoundException();
    }

    @Transactional
    public void delete(Integer id)
    {
        taskService.deleteByUserStoryId(id);
        bugService.deleteByUserStoryId(id);
        userStoryRepo.deleteById(id);

    }

    @Transactional
    public UserStory update(UserStory userStory)
    {
        UserStoryEntity userStoryEntity = userStoryRepo.save(userStoryMapper.businessObjectToEntity(userStory));
        UserStory savedUserStory = userStoryMapper.entityToBusinessObject(userStoryEntity);


        if(!CollectionUtils.isEmpty(userStory.getTaskList()))
        {
            userStory.getTaskList()
                    .stream()
                    .filter(task -> task.getUserStoryId() == null )
                    .forEach(task -> task.setUserStoryId(savedUserStory.getId()));

            savedUserStory.setTaskList(taskService.create(userStory.getTaskList()));
        }

        if(!CollectionUtils.isEmpty(userStory.getBugList()))
        {
            userStory.getBugList()
                    .stream()
                    .filter(bug -> bug.getUserStoryId() == null )
                    .forEach(bug -> bug.setUserStoryId(savedUserStory.getId()));

            savedUserStory.setBugList(bugService.create(userStory.getBugList()));
        }

        return savedUserStory;
    }



}
