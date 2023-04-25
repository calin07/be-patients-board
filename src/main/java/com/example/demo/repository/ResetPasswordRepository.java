package com.example.demo.repository;

import com.example.demo.model.ResetPasswordRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResetPasswordRepository extends JpaRepository<ResetPasswordRequest, Long> {
    Optional<ResetPasswordRequest> findByRequestId(UUID requestId);
}
