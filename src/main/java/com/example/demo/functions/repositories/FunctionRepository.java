package com.example.demo.functions.repositories;

import com.example.demo.model.Function;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionRepository extends JpaRepository<Function, Long> {
}
