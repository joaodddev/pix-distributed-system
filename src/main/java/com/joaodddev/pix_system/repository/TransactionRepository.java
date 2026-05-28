package com.joaodddev.pix_system.repository;

import com.joaodddev.pix_system.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
