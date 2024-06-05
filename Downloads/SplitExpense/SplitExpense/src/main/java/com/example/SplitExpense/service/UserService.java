package com.example.SplitExpense.service;

import com.example.SplitExpense.dto.GroupResponseDTO;
import com.example.SplitExpense.dto.UserExpenseDTO;
import com.example.SplitExpense.dto.UserRequestDTO;
import com.example.SplitExpense.dto.UserResponseDTO;
import com.example.SplitExpense.exception.GroupNotFoundException;
import com.example.SplitExpense.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    UserResponseDTO register(UserRequestDTO userRequestDTO);
    UserResponseDTO getuserById(int userId) throws UserNotFoundException;
    List<GroupResponseDTO> getGroupsofUser(int userId) throws UserNotFoundException;
    void AddUserInGroup(int userId,int groupId) throws UserNotFoundException, GroupNotFoundException;

}
