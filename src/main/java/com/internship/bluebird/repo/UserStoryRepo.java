package com.internship.bluebird.repo;

import com.internship.bluebird.domain.UserStoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepo extends JpaRepository<UserStoryEntity,Integer>{
    List<UserStoryEntity> findByUserId(Integer id);
    void deleteByUserId(Integer id);
}
