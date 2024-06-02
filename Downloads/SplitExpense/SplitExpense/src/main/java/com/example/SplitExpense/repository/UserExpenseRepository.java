package com.example.SplitExpense.repository;

import com.example.SplitExpense.model.UserExpense;
import com.example.SplitExpense.model.UserExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense,Integer> {
}
