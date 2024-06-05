package com.example.SplitExpense.service;

import com.example.SplitExpense.dto.UserExpenseDTO;
import com.example.SplitExpense.exception.ExpenseNotFoundException;
import com.example.SplitExpense.exception.UserExpenseNotFoundException;
import com.example.SplitExpense.exception.UserNotFoundException;

import java.util.List;

public interface UserExpenseService {

     List<UserExpenseDTO> getExpensesByUserId(int userId) throws UserNotFoundException;

    String addUserExpense(int userId, UserExpenseDTO userExpenseDTO) throws UserNotFoundException;

    String addUserExpenseToGroup(int expenseId, int userExpenseId) throws ExpenseNotFoundException, UserExpenseNotFoundException;
}
