package com.joaodddev.pix_system.service;

import com.joaodddev.pix_system.dto.CreateAccountRequest;
import com.joaodddev.pix_system.entity.AccountEntity;
import com.joaodddev.pix_system.entity.UserEntity;
import com.joaodddev.pix_system.repository.AccountRepository;
import com.joaodddev.pix_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountEntity create(
            CreateAccountRequest request
    ) {

        UserEntity user = userRepository.findById(
                request.userId()
        ).orElseThrow(() ->
                new RuntimeException("User not found")
        );

        AccountEntity account = AccountEntity.builder()
                .user(user)
                .pixKey(request.pixKey())
                .balance(request.balance())
                .build();

        return accountRepository.save(account);
    }
}
