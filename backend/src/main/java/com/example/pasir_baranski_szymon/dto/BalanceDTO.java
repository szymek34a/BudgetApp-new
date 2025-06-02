package com.example.pasir_baranski_szymon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceDTO {
    private Double totalIncome;
    private Double totalExpense;
    private Double balance;
}
