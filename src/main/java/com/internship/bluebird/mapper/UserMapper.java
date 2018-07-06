package com.internship.bluebird.mapper;

import com.internship.bluebird.domain.UserEntity;
import com.internship.bluebird.dto.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User entityToBusinessObject(UserEntity userEntity);

    List<User> entitiesToBusinessObject(List<UserEntity> userEntityList);

    UserEntity businessObjectToEntity(User userBusinessObject);

    List<UserEntity> businessObjectsToEntities(List<User> userBusinessObjectList);
    
}
