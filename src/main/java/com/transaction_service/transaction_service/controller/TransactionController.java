package com.transaction_service.transaction_service.controller;

import com.transaction_service.transaction_service.models.entities.Transaction;
import com.transaction_service.transaction_service.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionservice;

    @GetMapping("")
    private List<Transaction> ListarTransaccion() {
        return transactionservice.ListarTransaccion();
    }
}
