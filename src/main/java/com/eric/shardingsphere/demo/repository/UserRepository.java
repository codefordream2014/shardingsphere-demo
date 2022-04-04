package com.eric.shardingsphere.demo.repository;

import com.eric.shardingsphere.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(Long userId);

    List<UserEntity> findByName(String name);
}
