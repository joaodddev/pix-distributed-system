package com.joaodddev.pix_system.repository;

import com.joaodddev.pix_system.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByPixKey(String pixKey);
}
