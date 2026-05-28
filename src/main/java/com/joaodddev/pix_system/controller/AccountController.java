package com.joaodddev.pix_system.controller;

import com.joaodddev.pix_system.dto.CreateAccountRequest;
import com.joaodddev.pix_system.entity.AccountEntity;
import com.joaodddev.pix_system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountEntity create(
            @RequestBody CreateAccountRequest request
    ) {

        return accountService.create(request);
    }
}

