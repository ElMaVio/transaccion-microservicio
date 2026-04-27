package com.transaction_service.transaction_service.repositories;


import com.transaction_service.transaction_service.models.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
