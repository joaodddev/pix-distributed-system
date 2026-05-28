package com.joaodddev.pix_system.controller;

import com.joaodddev.pix_system.dto.LoginRequest;
import com.joaodddev.pix_system.dto.LoginResponse;
import com.joaodddev.pix_system.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        return authService.login(request);
    }
}