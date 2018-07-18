package com.internship.bluebird.repo;

import com.internship.bluebird.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    @Modifying
    @Query("Update UserEntity u Set u.isActive=false where u.id=:id")
    void softDelete(@Param("id") Integer id);
}
