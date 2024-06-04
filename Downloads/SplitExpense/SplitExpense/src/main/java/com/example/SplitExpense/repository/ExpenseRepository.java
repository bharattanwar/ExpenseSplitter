package com.example.SplitExpense.repository;

import com.example.SplitExpense.model.Expense;
import com.example.SplitExpense.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    Optional<Expense> findByDescriptionAndGroup(String description,Group group);
}
