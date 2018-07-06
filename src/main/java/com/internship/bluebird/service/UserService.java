package com.internship.bluebird.service;

import com.internship.bluebird.domain.UserEntity;
import com.internship.bluebird.dto.User;
import com.internship.bluebird.mapper.UserMapper;
import com.internship.bluebird.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    private UserMapper userMapper;


    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;

    }

    public User create(User user) {
        UserEntity userEntity = userMapper.businessObjectToEntity(user);
        return userMapper.entityToBusinessObject(userRepo.save(userEntity));
    }

    public User get(Integer id) {
        Optional<UserEntity> userEntityOptional = userRepo.findById(id);

        if (userEntityOptional.isPresent()) {

            return userMapper.entityToBusinessObject(userEntityOptional.get());
        }

        throw new EntityNotFoundException();
    }

    public User update(User user) {
        UserEntity userEntity = userMapper.businessObjectToEntity(user);
        return userMapper.entityToBusinessObject(userRepo.save(userEntity));
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }


}
