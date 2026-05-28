package com.joaodddev.pix_system.service;

import com.joaodddev.pix_system.dto.PixTransferRequest;
import com.joaodddev.pix_system.entity.AccountEntity;
import com.joaodddev.pix_system.entity.TransactionEntity;
import com.joaodddev.pix_system.repository.AccountRepository;
import com.joaodddev.pix_system.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void transfer(PixTransferRequest request) {

        AccountEntity sender = accountRepository
                .findByPixKey(request.senderPixKey())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        AccountEntity receiver = accountRepository
                .findByPixKey(request.receiverPixKey())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        if (sender.getBalance().compareTo(request.amount()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance().subtract(request.amount()));
        receiver.setBalance(receiver.getBalance().add(request.amount()));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        TransactionEntity transaction = TransactionEntity.builder()
                .senderPixKey(request.senderPixKey())
                .receiverPixKey(request.receiverPixKey())
                .amount(request.amount())
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);
    }
}