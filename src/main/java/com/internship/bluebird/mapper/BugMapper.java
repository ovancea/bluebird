package com.internship.bluebird.mapper;

import com.internship.bluebird.domain.BugEntity;
import com.internship.bluebird.dto.Bug;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BugMapper {

    Bug entityToBusinessObject(BugEntity bugEntity);

    List<Bug> entitiesToBusinessObject(List<BugEntity> bugEntityList);

    BugEntity businessObjectToEntity(Bug bugBusinessObject);

    List<BugEntity> businessObjectsToEntities(List<Bug> bugBusinessObjectList);

}