package com.internship.bluebird.repo;

import com.internship.bluebird.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {
}