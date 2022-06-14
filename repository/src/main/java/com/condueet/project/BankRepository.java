package com.condueet.project;

import com.condueet.project.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findById(Long id);

    Optional<Bank> findBankByName(String name);
}
