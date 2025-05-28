package com.taxi.service;

import com.taxi.entity.UserEntity;
import com.taxi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // распаковываем Optional или бросаем исключение
        UserEntity user = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден: " + username));

        // конвертим в Spring Security UserDetails
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getName())
                .password(user.getPass())
                .roles(user.getRole())  // автоматически префиксирует ROLE_
                .build();
    }
}

