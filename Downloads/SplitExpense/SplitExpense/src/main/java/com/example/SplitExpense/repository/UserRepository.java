package com.example.SplitExpense.repository;

import com.example.SplitExpense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
