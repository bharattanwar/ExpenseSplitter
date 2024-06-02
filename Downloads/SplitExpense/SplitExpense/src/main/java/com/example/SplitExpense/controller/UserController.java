package com.example.SplitExpense.controller;

import com.example.SplitExpense.dto.GroupResponseDTO;
import com.example.SplitExpense.dto.UserRequestDTO;
import com.example.SplitExpense.dto.UserResponseDTO;
import com.example.SplitExpense.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.register(userRequestDTO));
    }

    // to get a group of user by user_id :
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable int userId){
        return ResponseEntity.ok(userService.getuserById(userId));
    }
}
