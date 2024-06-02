package com.example.SplitExpense.repository;

import com.example.SplitExpense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
