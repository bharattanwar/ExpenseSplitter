package com.example.SplitExpense.repository;

import com.example.SplitExpense.model.User;
import com.example.SplitExpense.model.UserExpense;
import com.example.SplitExpense.model.UserExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense,Integer> {
    List<UserExpense> findByUser(User user);
}
