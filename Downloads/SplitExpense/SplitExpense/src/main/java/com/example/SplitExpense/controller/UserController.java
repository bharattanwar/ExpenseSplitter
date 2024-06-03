package com.example.SplitExpense.controller;

import com.example.SplitExpense.dto.GroupResponseDTO;
import com.example.SplitExpense.dto.UserRequestDTO;
import com.example.SplitExpense.dto.UserResponseDTO;
import com.example.SplitExpense.exception.GroupNotFoundException;
import com.example.SplitExpense.exception.UserNotFoundException;
import com.example.SplitExpense.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.register(userRequestDTO));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable int userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getuserById(userId));
    }

    // to get a group of user by user_id :
    @GetMapping("/{userId}/getGroups")
    public ResponseEntity<List<GroupResponseDTO>> getGroupsInfo(@PathVariable int userId) throws UserNotFoundException{
        List<GroupResponseDTO> groupResponseDTOS = userService.getGroupsofUser(userId);
        return ResponseEntity.ok(groupResponseDTOS);
    }

    // adding user in particular group
    @PostMapping("/{userId}/addUser/{groupId}")
    public ResponseEntity<String> AddUserInGroup(@PathVariable int userId,@PathVariable int groupId) throws UserNotFoundException, GroupNotFoundException {
        userService.AddUserInGroup(userId,groupId);
        return ResponseEntity.ok("User is added to the group");
    }

}
