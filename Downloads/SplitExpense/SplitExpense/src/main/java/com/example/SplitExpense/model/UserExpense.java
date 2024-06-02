package com.example.SplitExpense.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;

    @Enumerated(EnumType.STRING)
    private  UserExpenseType userExpenseType;
}
