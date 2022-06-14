package com.condueet.project;

import com.condueet.project.dto.BankDto;
import com.condueet.project.exceptions.AllBankException;
import com.condueet.project.exceptions.BankDoesNotExistException;
import com.condueet.project.model.Bank;

import java.util.List;

public interface BankService {

    List<Bank> getAllBanks();

    Bank findBankByName(String name) throws BankDoesNotExistException;

    Bank createBank(BankDto bankDto) throws AllBankException;

    Bank updateBankInfo(Long bank) throws AllBankException;

    boolean deleteBankInfo(Long bank) throws AllBankException;


}
