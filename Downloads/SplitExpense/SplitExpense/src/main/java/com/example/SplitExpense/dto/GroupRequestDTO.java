package com.example.SplitExpense.dto;

import com.example.SplitExpense.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupRequestDTO {
    private String groupName;
    private String description;
    private Currency defaultCurrency;
    private List<Integer> userIds;

}
