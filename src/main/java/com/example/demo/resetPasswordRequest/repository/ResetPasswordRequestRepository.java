package com.example.demo.resetPasswordRequest.repository;
import com.example.demo.login.entity.ResetPasswordRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordRequestRepository extends JpaRepository<ResetPasswordRequest,Long> {
}
