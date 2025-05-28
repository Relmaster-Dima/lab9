package com.taxi.repository;

import com.taxi.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
    java.util.List<DriverEntity> findAllByDeletedFalse();
}
