package com.example.SplitExpense.dto;

import com.example.SplitExpense.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private String email;

    public static UserResponseDTO from(User user){
        if(user == null){
            return null;
        }
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.name = user.getName();
        userResponseDTO.email = user.getEmail();
        return userResponseDTO;
    }
    public static User from(UserResponseDTO userResponseDTO){
        if(userResponseDTO == null){
            return null;
        }
        User user = new User();
        user.setName(userResponseDTO.getName());
        user.setEmail(userResponseDTO.getEmail());
        return user;
    }

}

