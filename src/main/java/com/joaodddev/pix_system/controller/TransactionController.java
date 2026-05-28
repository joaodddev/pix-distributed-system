package com.joaodddev.pix_system.controller;

import com.joaodddev.pix_system.dto.PixTransferRequest;
import com.joaodddev.pix_system.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@Valid
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/pix")
    public ResponseEntity<String> transfer(
            @RequestBody PixTransferRequest request
    ) {
        transactionService.transfer(request);
        return ResponseEntity.ok("Transferência realizada com sucesso.");
}
}