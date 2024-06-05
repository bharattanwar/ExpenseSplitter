package com.example.SplitExpense.controller;

import com.example.SplitExpense.dto.UserExpenseDTO;
import com.example.SplitExpense.exception.ExpenseNotFoundException;
import com.example.SplitExpense.exception.UserExpenseNotFoundException;
import com.example.SplitExpense.exception.UserNotFoundException;
import com.example.SplitExpense.service.UserExpenseService;
import com.example.SplitExpense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userExpense")
public class UserExpenseController {
    @Autowired
    private UserExpenseService userExpenseService;
    @Autowired
    private UserService userService;

    // Creating UserExpense
    @PostMapping("{userId}/createExpense")
    public ResponseEntity<String> createUserExpense(@PathVariable int userId, @RequestBody UserExpenseDTO userExpenseDTO) throws UserNotFoundException{
        return ResponseEntity.ok(userExpenseService.addUserExpense(userId, userExpenseDTO));
    }

    // Adding an Expense to a Group
    @PostMapping("/{expenseId}/addUserExpense/{userExpenseId}")
    public ResponseEntity<String> addUserExpenseToGroup(@PathVariable int expenseId,@PathVariable int userExpenseId) throws ExpenseNotFoundException, UserExpenseNotFoundException {
        return ResponseEntity.ok(userExpenseService.addUserExpenseToGroup(expenseId,userExpenseId));
    }

    @GetMapping("/{userId}/getUserExpense")
    public ResponseEntity<List<UserExpenseDTO>> getExpensesbyUserId(@PathVariable int userId) throws UserNotFoundException{
        return ResponseEntity.ok(userExpenseService.getExpensesByUserId(userId));
    }
}
