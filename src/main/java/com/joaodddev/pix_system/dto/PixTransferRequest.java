package com.joaodddev.pix_system.dto;

import java.math.BigDecimal;

public record PixTransferRequest(
        String senderPixKey,
        String receiverPixKey,
        BigDecimal amount
) {
}
