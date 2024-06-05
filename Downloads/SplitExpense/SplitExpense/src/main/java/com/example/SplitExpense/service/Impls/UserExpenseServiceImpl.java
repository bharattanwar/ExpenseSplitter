package com.example.SplitExpense.service.Impls;

import com.example.SplitExpense.dto.UserExpenseDTO;
import com.example.SplitExpense.exception.ExpenseNotFoundException;
import com.example.SplitExpense.exception.UserExpenseNotFoundException;
import com.example.SplitExpense.exception.UserNotFoundException;
import com.example.SplitExpense.model.Expense;
import com.example.SplitExpense.model.User;
import com.example.SplitExpense.model.UserExpense;
import com.example.SplitExpense.repository.ExpenseRepository;
import com.example.SplitExpense.repository.UserExpenseRepository;
import com.example.SplitExpense.repository.UserRepository;
import com.example.SplitExpense.service.UserExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserExpenseServiceImpl implements UserExpenseService{
    @Autowired
    private UserExpenseRepository userExpenseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<UserExpenseDTO> getExpensesByUserId(int userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
        List<UserExpense> userExpenses = userExpenseRepository.findByUser(user);
        List<UserExpenseDTO> userExpenseDTOs = new ArrayList<>();
        for (UserExpense userExpense : userExpenses) {
            userExpenseDTOs.add(UserExpenseDTO.from(userExpense));
        }
        return userExpenseDTOs;
    }


    @Override
    public String addUserExpense(int userId, UserExpenseDTO userExpenseDTO) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }
        User user = userOptional.get();
        // Create a new UserExpense entity and set its properties
        UserExpense userExpense = new UserExpense();
        userExpense.setUser(user);
        userExpense.setAmount(userExpenseDTO.getAmount());
        userExpense.setUserExpenseType(userExpenseDTO.getUserExpenseType());
        userExpenseRepository.save(userExpense);
        return "User expense added successfully for user ID " + userId;
    }

    @Override
    public String addUserExpenseToGroup(int expenseId, int userExpenseId) throws ExpenseNotFoundException, UserExpenseNotFoundException {
        UserExpense userExpense = userExpenseRepository.findById(userExpenseId).orElseThrow(
                () -> new UserExpenseNotFoundException("No User expense is found with Id :" + userExpenseId)
        );
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(
                () -> new ExpenseNotFoundException("No expense found with id :" + expenseId)
        );
        List<UserExpense> userExpenses = expense.getUserExpenses();
        if(userExpenses == null){
            userExpenses = new ArrayList<>();
        }
        userExpenses.add(userExpense);
        expense.setUserExpenses(userExpenses);
        expenseRepository.save(expense);
        return "User expense is added to the Group with expenseId as :" + expenseId ;
    }
}
