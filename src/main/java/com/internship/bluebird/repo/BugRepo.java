package com.internship.bluebird.repo;

import com.internship.bluebird.domain.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepo extends JpaRepository<BugEntity,Integer> {

    List<BugEntity> findByUserStoryId(Integer id);
    List<BugEntity> findByUserId(Integer id);

    void deleteByUserStoryId(Integer id);
    void deleteByUserId(Integer id);

}