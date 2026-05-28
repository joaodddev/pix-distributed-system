package com.joaodddev.pix_system.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record PixTransferRequest(

        @NotBlank(message = "Sender Pix is required")
        String senderPixKey,

        @NotBlank(message = "Receiver Pix is required")
        String receiverPixKey,

        @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
        BigDecimal amount
) {
}
