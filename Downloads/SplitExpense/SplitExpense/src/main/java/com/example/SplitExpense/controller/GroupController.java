package com.example.SplitExpense.controller;

import com.example.SplitExpense.dto.ExpenseDTO;
import com.example.SplitExpense.dto.GroupRequestDTO;
import com.example.SplitExpense.dto.GroupResponseDTO;
import com.example.SplitExpense.dto.TransactionDTO;
import com.example.SplitExpense.exception.GroupNotFoundException;
import com.example.SplitExpense.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/createGroup")
    public ResponseEntity<GroupResponseDTO> createGroup(@RequestBody GroupRequestDTO groupRequestDTO){
        return ResponseEntity.ok(groupService.createGroup(groupRequestDTO));
    }

    @GetMapping("/{groupId}/getExpense")
    public ResponseEntity<Double> getTotalAmount(@PathVariable("groupId") int groupId) throws GroupNotFoundException{
        return ResponseEntity.ok(groupService.getTotalAmount(groupId));
    }

    @GetMapping("/settleup/{groupId}")
    public ResponseEntity<List<TransactionDTO>> settleUpForGroup(@PathVariable("groupId") int groupId) throws GroupNotFoundException{
        List<TransactionDTO> transactions = groupService.settleupGroupId(groupId);
        return ResponseEntity.ok(transactions);
    }
}
