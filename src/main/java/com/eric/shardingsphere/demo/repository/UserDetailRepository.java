package com.eric.shardingsphere.demo.repository;

import com.eric.shardingsphere.demo.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long> {

    UserDetailEntity findByUserId(Long userId);

    List<UserDetailEntity> findByPhone(String phone);

}
