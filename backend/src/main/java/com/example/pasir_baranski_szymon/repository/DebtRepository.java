package com.example.pasir_baranski_szymon.repository;

import com.example.pasir_baranski_szymon.model.Debt;
import com.example.pasir_baranski_szymon.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, Long> {
    List<Debt> findByGroupId(Long groupId);
}
