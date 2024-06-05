package com.example.SplitExpense.dto;

import com.example.SplitExpense.model.User;
import com.example.SplitExpense.model.UserExpense;
import com.example.SplitExpense.model.UserExpenseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserExpenseDTO {
    private double amount;
    private UserExpenseType userExpenseType;

    public static UserExpenseDTO from(UserExpense userExpense){
        UserExpenseDTO userExpenseDTO = new UserExpenseDTO();
        userExpenseDTO.amount = userExpense.getAmount();
        userExpenseDTO.userExpenseType = userExpense.getUserExpenseType();
        return userExpenseDTO;
    }
}
