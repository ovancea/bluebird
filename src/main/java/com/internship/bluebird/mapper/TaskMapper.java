package com.internship.bluebird.mapper;

import com.internship.bluebird.domain.TaskEntity;
import com.internship.bluebird.dto.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task entityToBusinessObject(TaskEntity taskEntity);

    List<Task> entitiesToBusinessObject(List<TaskEntity> taskEntityList);

    TaskEntity businessObjectToEntity(Task taskBusinessObject);

    List<TaskEntity> businessObjectsToEntities(List<Task> taskBusinessObjectList);

}