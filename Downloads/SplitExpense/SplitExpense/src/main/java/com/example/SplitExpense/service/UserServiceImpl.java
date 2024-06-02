package com.example.SplitExpense.service;

import com.example.SplitExpense.dto.UserRequestDTO;
import com.example.SplitExpense.dto.UserResponseDTO;
import com.example.SplitExpense.exception.UserNotFoundException;
import com.example.SplitExpense.model.User;
import com.example.SplitExpense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDTO register(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhoneNumber(userRequestDTO.getPhonenumber());
        return UserResponseDTO.from(userRepository.save(user));
    }

    @Override
    public UserResponseDTO getuserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("No User Found")
        );
        return UserResponseDTO.from(user);
    }
}
