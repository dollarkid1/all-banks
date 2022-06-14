package com.condueet.project;

import com.condueet.project.model.Bank;

import java.util.List;

public interface BankService {

    List<Bank> getAllBanks();

    Bank findBankByName(String name);

    Bank createBank();

    Bank updateBank(Long bank);
}
