package com.example.SplitExpense.service.Impls;

import com.example.SplitExpense.service.Strategy.SettleUpStrategy;
import com.example.SplitExpense.service.Strategy.SettleUpStrategyFactory;
import com.example.SplitExpense.dto.GroupRequestDTO;
import com.example.SplitExpense.dto.GroupResponseDTO;
import com.example.SplitExpense.dto.TransactionDTO;
import com.example.SplitExpense.exception.GroupNotFoundException;
import com.example.SplitExpense.exception.UserNotFoundException;
import com.example.SplitExpense.model.Expense;
import com.example.SplitExpense.model.Group;
import com.example.SplitExpense.model.User;
import com.example.SplitExpense.repository.GroupRepository;
import com.example.SplitExpense.repository.UserRepository;
import com.example.SplitExpense.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public GroupResponseDTO createGroup(GroupRequestDTO groupRequestDTO) {
        Group group = new Group();
        group.setGroupName(groupRequestDTO.getGroupName());
        group.setDescription(groupRequestDTO.getDescription());
        group.setCurrency(groupRequestDTO.getDefaultCurrency()); // Set the currency

        List<User> users = new ArrayList<>();
        for (int userId : groupRequestDTO.getUserIds()) {
            User user = userRepository.findById(userId).orElseThrow(
                    () -> new UserNotFoundException("User not found with ID: " + userId)
            );
            users.add(user);
        }
        group.setUsers(users);
        Group savedGroup = groupRepository.save(group);
        return GroupResponseDTO.from(savedGroup);
    }

    @Override
    public double getTotalAmount(int groupId) throws GroupNotFoundException {
        // will change to group name
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new GroupNotFoundException("The group with Id :" +groupId + "does not exist")
        );
        List<Expense> expenses = group.getExpenses();
        int TotalAmount = 0;
        for(Expense expense : expenses){
            TotalAmount += expense.getAmount();
        }
        group.setAmountToBeSettled(TotalAmount);
        groupRepository.save(group);
        return TotalAmount;
    }

    @Override
    public List<TransactionDTO> settleupGroupId(int groupId) throws GroupNotFoundException {
        SettleUpStrategy strategy = SettleUpStrategyFactory.getSettleUpStrategy();
        Optional<Group> savedGroup = Optional.ofNullable(groupRepository.findById(groupId).orElseThrow(
                () -> new GroupNotFoundException("Group not found with Id :" + groupId)
        ));
        List<TransactionDTO> transactions = strategy.settleUp(savedGroup.get().getExpenses());
        return transactions;
    }
}
