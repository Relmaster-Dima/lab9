package com.taxi.repository;

import com.taxi.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
    java.util.List<PassengerEntity> findAllByDeletedFalse();
}
