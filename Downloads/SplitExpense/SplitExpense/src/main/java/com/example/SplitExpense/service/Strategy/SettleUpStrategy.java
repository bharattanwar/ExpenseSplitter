package com.example.SplitExpense.service.Strategy;

import com.example.SplitExpense.dto.TransactionDTO;
import com.example.SplitExpense.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO> settleUp(List<Expense> expenses);
}
