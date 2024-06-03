package com.example.SplitExpense.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Split_Group")
public class Group extends BaseModel{
    private String groupName;
    private double AmountToBeSettled;
    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToMany
    private List<User> users  = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Expense> expenses;

}
