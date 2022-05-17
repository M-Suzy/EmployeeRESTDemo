package com.example.employeerestdemo.repository;

import com.example.employeerestdemo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
