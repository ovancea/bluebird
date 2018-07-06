package com.internship.bluebird.repo;

import com.internship.bluebird.domain.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepo extends JpaRepository<BugEntity,Integer> {
}