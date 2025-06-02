package com.example.pasir_baranski_szymon.repository;

import com.example.pasir_baranski_szymon.model.Transaction;
import com.example.pasir_baranski_szymon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByUser(User user);
}
