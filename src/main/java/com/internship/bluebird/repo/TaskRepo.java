package com.internship.bluebird.repo;

import com.internship.bluebird.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {

    List<TaskEntity> findByUserStoryId(Integer id);

    void deleteByUserStoryId(Integer id);

}