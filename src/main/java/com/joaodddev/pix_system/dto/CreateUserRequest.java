package com.joaodddev.pix_system.dto;

public record CreateUserRequest(

        String name,
        String email,
        String password

) {
}
