package com.joaodddev.pix_system.security;

import com.joaodddev.pix_system.dto.LoginRequest;
import com.joaodddev.pix_system.dto.LoginResponse;
import com.joaodddev.pix_system.entity.UserEntity;
import com.joaodddev.pix_system.repository.UserRepository;
import com.joaodddev.pix_system.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        UserEntity user = userRepository
                .findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean passwordMatches = passwordEncoder.matches(
                request.password(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}