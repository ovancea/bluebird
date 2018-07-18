package com.internship.bluebird.service;

import com.internship.bluebird.domain.UserEntity;
import com.internship.bluebird.dto.User;
import com.internship.bluebird.mapper.UserMapper;
import com.internship.bluebird.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    private UserMapper userMapper;
    private BugService bugService;
    private UserStoryService userStoryService;
    private TaskService taskService;


    public UserService(UserRepo userRepo, UserMapper userMapper, BugService bugService, UserStoryService userStoryService, TaskService taskService) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.bugService = bugService;
        this.userStoryService = userStoryService;
        this.taskService = taskService;
    }

    @Transactional
    public User create(User user) {

        UserEntity userEntity = userRepo.save(userMapper.businessObjectToEntity(user));
        return userMapper.entityToBusinessObject(userRepo.save(userEntity));
    }



    public User get(Integer id) {
        Optional<UserEntity> userEntityOptional = userRepo.findById(id);

        if (userEntityOptional.isPresent()) {

            if(userEntityOptional.isPresent()){
                User savedUser = userMapper.entityToBusinessObject(userEntityOptional.get());
                savedUser.setUserStoryList(userStoryService.findByUserId(id));
                savedUser.setBugList(bugService.findByUserId(id));
                savedUser.setTaskList(taskService.findByUserId(id));
            }
            return userMapper.entityToBusinessObject(userEntityOptional.get());
        }

        throw new EntityNotFoundException();
    }

    @Transactional
    public User update(User user) {
        UserEntity userEntity = userRepo.save(userMapper.businessObjectToEntity(user));
        User savedUser = userMapper.entityToBusinessObject(userEntity);
        return savedUser;
    }

    @Transactional
    public void delete(Integer id) {
        userRepo.softDelete(id);
    }



}
