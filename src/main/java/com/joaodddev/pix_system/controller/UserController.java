package com.joaodddev.pix_system.controller;

import com.joaodddev.pix_system.dto.CreateUserRequest;
import com.joaodddev.pix_system.entity.UserEntity;
import com.joaodddev.pix_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity create(
            @Valid @RequestBody CreateUserRequest request
    ) {

        return userService.create(request);
    }
}

