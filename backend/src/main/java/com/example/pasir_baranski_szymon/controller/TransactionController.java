package com.example.pasir_baranski_szymon.controller;

import com.example.pasir_baranski_szymon.dto.TransactionDTO;
import com.example.pasir_baranski_szymon.model.Transaction;
import com.example.pasir_baranski_szymon.repository.TransactionRepository;
import com.example.pasir_baranski_szymon.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable Long id,
            @Valid @RequestBody TransactionDTO transactionDTO) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionDTO);
        return ResponseEntity.ok(updatedTransaction);
    }
//    @Autowired
//    private TransactionRepository transactionRepository;
//
//    @GetMapping
//    public ResponseEntity<List<Transaction>> getAllTransactions() {
//        List<Transaction> transactions = transactionRepository.findAll();
//        return ResponseEntity.ok(transactions);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transactionDetails) {
//        Transaction transaction = transactionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
//
//        transaction.setAmount(transactionDetails.getAmount());
//        transaction.setType(transactionDetails.getType());
//        transaction.setTags(transactionDetails.getTags());
//        transaction.setNotes(transactionDetails.getNotes());
//
//        Transaction updatedTransaction = transactionRepository.save(transaction);
//        return ResponseEntity.ok(updatedTransaction);
//    }
// Moja stara wersja
//    @PostMapping
//    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
//        Transaction savedTransaction = transactionRepository.save(transaction);
//        return ResponseEntity.ok(savedTransaction);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
//        Transaction transaction = transactionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
//
//        transactionRepository.delete(transaction);
//        return ResponseEntity.noContent().build();
//    }


    // tu dzialajaca wersja
//    @PostMapping
//    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
//        Transaction savedTransaction = transactionRepository.save(transaction);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
//        Transaction transaction = transactionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
//
//        transactionRepository.delete(transaction);
//        return ResponseEntity.noContent().build();
//    }
    //tu niby okej
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(
            @Valid @RequestBody TransactionDTO transactionDTO) {
        Transaction savedTransaction = transactionService.createTransaction(transactionDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
