package com.taxi.service;

import com.taxi.entity.UserEntity;
import com.taxi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerNewUser(String name, String pass) {
        if (userRepository.existsByName(name)) {
            throw new RuntimeException("Пользователь с этим именем уже существует");
        }
        // здесь можно хешировать пароль, если понадобиться
        UserEntity u = new UserEntity(name, pass, "User");
        userRepository.save(u);
    }
}
