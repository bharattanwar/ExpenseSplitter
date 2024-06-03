package com.example.SplitExpense.service;

import com.example.SplitExpense.dto.ExpenseDTO;
import com.example.SplitExpense.dto.GroupRequestDTO;
import com.example.SplitExpense.dto.GroupResponseDTO;
import com.example.SplitExpense.dto.TransactionDTO;
import com.example.SplitExpense.exception.GroupNotFoundException;

import java.util.List;

public interface GroupService {
    GroupResponseDTO createGroup(GroupRequestDTO groupRequestDTO);
    double getTotalAmount(int groupId) throws GroupNotFoundException;
    List<TransactionDTO> settleupGroupId(int groupId) throws GroupNotFoundException;
}
