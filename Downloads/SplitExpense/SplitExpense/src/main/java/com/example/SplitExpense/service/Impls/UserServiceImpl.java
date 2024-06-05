package com.example.SplitExpense.service.Impls;

import com.example.SplitExpense.dto.GroupResponseDTO;
import com.example.SplitExpense.dto.UserRequestDTO;
import com.example.SplitExpense.dto.UserResponseDTO;
import com.example.SplitExpense.exception.GroupNotFoundException;
import com.example.SplitExpense.exception.UserNotFoundException;
import com.example.SplitExpense.model.Group;
import com.example.SplitExpense.model.User;
import com.example.SplitExpense.repository.GroupRepository;
import com.example.SplitExpense.repository.UserRepository;
import com.example.SplitExpense.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

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

    @Override
    public List<GroupResponseDTO> getGroupsofUser(int userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("No User Found")
        );
        List<Group> groups = groupRepository.findByUsersContaining(user);
        return groups.stream().map(GroupResponseDTO::from).collect(Collectors.toList());
    }

    @Override
    public void AddUserInGroup(int userId, int groupId) throws UserNotFoundException, GroupNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("No such user is found having Id : " + userId)
        );
        // try to change it to findbyname **
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new GroupNotFoundException("No such group exist with Id :" + groupId)
        );
        if (!group.getUsers().contains(user)) {
            group.getUsers().add(user);
        }

        // Adding the group to the user's groups
        if (!user.getGroups().contains(group)) {
            user.getGroups().add(group);
        }

        groupRepository.save(group);
    }
}
