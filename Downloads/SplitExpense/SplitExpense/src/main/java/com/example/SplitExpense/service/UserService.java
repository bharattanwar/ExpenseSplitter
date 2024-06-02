package com.example.SplitExpense.service;

import com.example.SplitExpense.dto.UserRequestDTO;
import com.example.SplitExpense.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO register(UserRequestDTO userRequestDTO);
    UserResponseDTO getuserById(int userId);
}
