package com.taxi.repository;

import com.taxi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Spring Data поймёт existsByName, потому что поле в энити называется name
    boolean existsByName(String name);

    Optional<UserEntity> findByName(String name);
}
