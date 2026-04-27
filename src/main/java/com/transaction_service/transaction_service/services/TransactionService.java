package com.transaction_service.transaction_service.services;

import com.transaction_service.transaction_service.models.entities.Transaction;
import com.transaction_service.transaction_service.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionService {
    @Autowired
    private TransactionRepository transactionrepository;

    public List<Transaction> ListarTransaccion() {
        return transactionrepository.findAll();
    }
}
