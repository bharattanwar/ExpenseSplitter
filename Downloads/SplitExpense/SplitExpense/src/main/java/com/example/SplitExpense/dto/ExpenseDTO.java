package com.example.SplitExpense.dto;

import com.example.SplitExpense.model.Currency;
import com.example.SplitExpense.model.Expense;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ExpenseDTO {
    private String description;
    private Currency currency;

    public static ExpenseDTO from(Expense expense){
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.description = expense.getDescription();
        expenseDTO.currency = expense.getCurrency();
        return expenseDTO;
    }
}
