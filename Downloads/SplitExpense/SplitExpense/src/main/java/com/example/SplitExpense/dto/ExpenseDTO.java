package com.example.SplitExpense.dto;

import com.example.SplitExpense.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ExpenseDTO {
    private String description;
    private Currency currency;
}
