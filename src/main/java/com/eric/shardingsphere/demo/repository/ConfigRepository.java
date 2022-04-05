package com.eric.shardingsphere.demo.repository;

import com.eric.shardingsphere.demo.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigRepository extends JpaRepository<ConfigEntity, Long> {
    List<ConfigEntity> findByName(String name);
}
