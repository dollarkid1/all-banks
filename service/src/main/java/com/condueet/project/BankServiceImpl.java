package com.condueet.project;

import com.condueet.project.dto.BankDto;
import com.condueet.project.exceptions.AllBankException;
import com.condueet.project.exceptions.BankDoesNotExistException;
import com.condueet.project.model.Bank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class BankServiceImpl implements BankService {

    @Autowired
    BankRepository repository;

    @Override
    public List<Bank> getAllBanks() {
        return repository.findAll();
    }

    @Override
    public Bank findBankByName(String name) throws BankDoesNotExistException {

        if (name == null) {
            throw new IllegalArgumentException("Name can not be null.");
        }

        Optional<Bank> queryResult;
        queryResult = repository.findBankByName(name);

        if (queryResult.isPresent()) {
            return queryResult.get();
        }

        throw new BankDoesNotExistException("Bank with name:" + name + " does not exist");
    }

    @Override
    public Bank createBank(BankDto bankDto) throws AllBankException {
        if (bankDto == null) {
            throw new IllegalArgumentException("Argument can not be null");
        }

        Optional<Bank> query = repository.findBankByName(bankDto.getName());
        if (query.isPresent()) {
            throw new AllBankException("Bank with name : " + bankDto.getName() + " already exist");
        }

        Bank bank = new Bank();
        bank.setName(bankDto.getName());
        bank.setUssdCode(bankDto.getUssdCode());

        return repository.save(bank);
    }

    @Override
    public Bank updateBankInfo(Long id) throws AllBankException {
        Optional<Bank> query = repository.findById(id);
        if (query.isEmpty()) {
            throw new AllBankException("Bank with ID " + id + " does not exist");
        }

        Bank targetBank = query.get();
        try {
            targetBank = applyChange(targetBank);
            log.info("Budget after patch -> {}", targetBank);
            return saveOrUpdate(targetBank);
        } catch (AllBankException e) {
            throw new AllBankException("Update failed");
        }
    }


    @Override
    public boolean deleteBankInfo(Long id) throws AllBankException {

        Optional<Bank> bank = repository.findById(id);

        if (bank.isPresent()) {
            repository.delete(bank.get());
            return true;
        }
        throw new AllBankException("Bank with " + id + " does not exist ");

    }


    private Bank applyChange(Bank targetBudget) {
        return null;
    }

    private Bank saveOrUpdate(Bank bank) throws AllBankException {
        if (bank == null) {
            throw new AllBankException("Budget can not be null");
        }
        return repository.save(bank);

    }


}




















