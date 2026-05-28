package com.joaodddev.pix_system.service;

import com.joaodddev.pix_system.dto.CreateUserRequest;
import com.joaodddev.pix_system.entity.UserEntity;
import com.joaodddev.pix_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserEntity create(CreateUserRequest request) {

        UserEntity user = UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .password(
                        passwordEncoder.encode(request.password())
                )
                .build();

        return userRepository.save(user);
    }
}