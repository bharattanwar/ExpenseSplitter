package com.example.SplitExpense.repository;

import com.example.SplitExpense.model.Group;
import com.example.SplitExpense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findByUsersContaining(User user);
}
