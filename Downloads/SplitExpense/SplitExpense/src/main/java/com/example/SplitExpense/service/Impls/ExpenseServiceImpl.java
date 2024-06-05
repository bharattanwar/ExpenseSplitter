package com.example.SplitExpense.service.Impls;

import com.example.SplitExpense.dto.ExpenseDTO;
import com.example.SplitExpense.exception.ExpenseNotFoundException;
import com.example.SplitExpense.exception.GroupNotFoundException;
import com.example.SplitExpense.model.Expense;
import com.example.SplitExpense.model.Group;
import com.example.SplitExpense.model.UserExpense;
import com.example.SplitExpense.model.UserExpenseType;
import com.example.SplitExpense.repository.ExpenseRepository;
import com.example.SplitExpense.repository.GroupRepository;
import com.example.SplitExpense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public ExpenseDTO createExpenseForGroup(int groupId, ExpenseDTO expenseDTO) throws GroupNotFoundException {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new GroupNotFoundException("No such group exists")
        );
        Optional<Expense> existingExpense = expenseRepository.findByDescriptionAndGroup(expenseDTO.getDescription(), group);
        if (existingExpense.isPresent()) {
            throw new IllegalArgumentException("Expense with the same description already exists for the group");
        }
        // see if amount is needed to be added here
        Expense expense = new Expense();
        expense.setDescription(expenseDTO.getDescription());
        expense.setCurrency(expenseDTO.getCurrency());

        // Save the new expense in the repository
        Expense savedExpense = expenseRepository.save(expense);

        // Add the expense to the group
        group.getExpenses().add(savedExpense);
        groupRepository.save(group);
        return ExpenseDTO.from(savedExpense);
    }

    @Override
    public double getTotalAmountForExpense(int expenseId) throws GroupNotFoundException , ExpenseNotFoundException {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(
                () -> new ExpenseNotFoundException("expense witn Id" + expenseId + "is not found")
        );
        List<UserExpense> userExpenses = expense.getUserExpenses();
        double totalAmount = 0;
        for(UserExpense userExpense:  userExpenses){
            if(userExpense.getUserExpenseType().equals(UserExpenseType.PaidBy)){
                totalAmount += userExpense.getAmount();
            }
        }
        expense.setAmount(totalAmount);
        expenseRepository.save(expense);
        return totalAmount;
    }
}
