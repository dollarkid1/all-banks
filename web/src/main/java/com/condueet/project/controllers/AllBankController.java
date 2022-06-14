package com.condueet.project.controllers;

import com.condueet.project.BankService;
import com.condueet.project.dto.BankDto;
import com.condueet.project.exceptions.AllBankException;
import com.condueet.project.model.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("banks")
@RequiredArgsConstructor
public class AllBankController {

    @Autowired
    BankService service;

    @GetMapping()
    public ResponseEntity<?> getAllBanks(){

        List<Bank> banks = service.getAllBanks();

        return ResponseEntity.ok().body(banks);

    }

    @PostMapping("/createBank")
    public ResponseEntity<?> createBank(BankDto bankDto){

        try{

            Bank saveBank = service.createBank(bankDto);
            return ResponseEntity.ok().body(saveBank);

        } catch (AllBankException | IllegalArgumentException exception) {

            return ResponseEntity.badRequest().body(exception.getMessage());

        }

    }

    @PostMapping("/updateBank")
    public ResponseEntity<?> updateBank(Long id){

        try{

            Bank updatedBudget = service.updateBankInfo(id);

            return ResponseEntity.ok().body(updatedBudget);

        } catch (AllBankException exception) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());

        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable Long id) throws AllBankException {

        try{

            boolean deletedBank = service.deleteBankInfo(id);

            return ResponseEntity.ok().body(true);

        } catch (AllBankException exception) {

            return ResponseEntity.badRequest().body(exception.getMessage());

        }

    }

}
