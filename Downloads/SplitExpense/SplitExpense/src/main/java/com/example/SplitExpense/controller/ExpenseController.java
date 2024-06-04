package com.example.SplitExpense.controller;

import com.example.SplitExpense.dto.ExpenseDTO;
import com.example.SplitExpense.exception.ExpenseNotFoundException;
import com.example.SplitExpense.exception.GroupNotFoundException;
import com.example.SplitExpense.repository.ExpenseRepository;
import com.example.SplitExpense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    // creating expense for a group
    @PostMapping("/{groupId}/create_expense")
    public ResponseEntity<ExpenseDTO> createExpenseForGroup(@PathVariable int groupId, @RequestBody ExpenseDTO expenseDTO) throws GroupNotFoundException{
        return ResponseEntity.ok(expenseService.createExpenseForGroup(groupId,expenseDTO));
    }

    // getting total amount for each expense
    @GetMapping("/{expenseId}/totalAmount")
    public ResponseEntity<Double> getTotalAmount(@PathVariable int expenseId) throws GroupNotFoundException, ExpenseNotFoundException {
        return ResponseEntity.ok(expenseService.getTotalAmountForExpense(expenseId));
    }
}
