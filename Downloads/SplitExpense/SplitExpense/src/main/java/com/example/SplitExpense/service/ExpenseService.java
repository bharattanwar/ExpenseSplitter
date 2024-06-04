package com.example.SplitExpense.service;

import com.example.SplitExpense.dto.ExpenseDTO;
import com.example.SplitExpense.exception.ExpenseNotFoundException;
import com.example.SplitExpense.exception.GroupNotFoundException;

public interface ExpenseService {
    ExpenseDTO createExpenseForGroup(int groupId,ExpenseDTO expenseDTO) throws GroupNotFoundException;
    double getTotalAmountForExpense(int expenseId) throws GroupNotFoundException , ExpenseNotFoundException;
}
