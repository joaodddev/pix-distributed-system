package com.joaodddev.pix_system.dto;

import java.math.BigDecimal;

public record CreateAccountRequest(

        Long userId,
        String pixKey,
        BigDecimal balance

) {
}
