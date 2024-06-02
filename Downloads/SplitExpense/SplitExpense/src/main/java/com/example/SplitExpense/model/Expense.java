package com.example.SplitExpense.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "Split_Expense")
public class Expense extends BaseModel{
    private double Amount;
    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany
    @JoinColumn(name = "expense_id")
    private List<UserExpense> userExpenses;
}
