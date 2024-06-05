package com.example.SplitExpense.service.Impls;

import com.example.SplitExpense.model.*;
import com.example.SplitExpense.repository.ExpenseRepository;
import com.example.SplitExpense.repository.GroupRepository;
import com.example.SplitExpense.repository.UserExpenseRepository;
import com.example.SplitExpense.repository.UserRepository;
import com.example.SplitExpense.service.InitService;
import com.example.SplitExpense.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public void init() {
        Group group=new Group();
        group.setId(1);
        group.setGroupName("Goa Trip");
        group.setDescription("Goa Trip 2023");
        group.setCurrency(Currency.Rupee);
        Group savedGroup =groupRepository.save(group);//for id

        User user1=User.builder()
                .name("Yash")
                .email("yash@gmail.com")
                .PhoneNumber("8475635462")
                .groups(java.util.List.of(savedGroup)).build();

        User user2=User.builder()
                .name("Sandeep")
                .email("sandy@gmail.com")
                .PhoneNumber("7485637221")
                .groups(java.util.List.of(savedGroup)).build();

        User user3=User.builder()
                .name("Swapnil")
                .email("swapnil@gmail.com")
                .PhoneNumber("9940506070")
                .groups(java.util.List.of(savedGroup)).build();

        User user4=User.builder()
                .name("Amit")
                .email("amit@gmail.com")
                .PhoneNumber("8475635662")
                .groups(java.util.List.of(savedGroup)).build();

        User user5=User.builder()
                .name("Pratik")
                .email("pratik@gmail.com")
                .PhoneNumber("9975635662")
                .groups(java.util.List.of(savedGroup)).build();

        User user6=User.builder()
                .name("Sahil")
                .email("sahil@gmail.com")
                .PhoneNumber("8475635782")
                .groups(java.util.List.of(savedGroup)).build();

        User savedUser1=userRepository.save(user1);
        User savedUser2=userRepository.save(user2);
        User savedUser3=userRepository.save(user3);
        User savedUser4=userRepository.save(user4);
        User savedUser5=userRepository.save(user5);
        User savedUser6=userRepository.save(user6);

        savedGroup.setUsers(List.of(savedUser1,savedUser2,savedUser3,savedUser4,savedUser5,savedUser6));
        savedGroup=groupRepository.save(savedGroup);

        UserExpense userExpense1=new UserExpense();
        userExpense1.setUserExpenseType(UserExpenseType.HasToPay);
        userExpense1.setAmount(500);
        userExpense1.setUser(savedUser1);
        UserExpense savedUserExpense1=userExpenseRepository.save(userExpense1);

        UserExpense userExpense2=new UserExpense();
        userExpense2.setUserExpenseType(UserExpenseType.HasToPay);
        userExpense2.setAmount(2000);
        userExpense2.setUser(savedUser2);
        UserExpense savedUserExpense2=userExpenseRepository.save(userExpense2);

        UserExpense userExpense3=new UserExpense();
        userExpense3.setUserExpenseType(UserExpenseType.HasToPay);
        userExpense3.setAmount(500);
        userExpense3.setUser(savedUser3);
        UserExpense savedUserExpense3=userExpenseRepository.save(userExpense3);

        UserExpense userExpense4=new UserExpense();
        userExpense4.setUserExpenseType(UserExpenseType.PaidBy);
        userExpense4.setAmount(1500);
        userExpense4.setUser(savedUser4);
        UserExpense savedUserExpense4=userExpenseRepository.save(userExpense4);

        UserExpense userExpense5=new UserExpense();
        userExpense5.setUserExpenseType(UserExpenseType.PaidBy);
        userExpense5.setAmount(500);
        userExpense5.setUser(savedUser5);
        UserExpense savedUserExpense5=userExpenseRepository.save(userExpense5);

        UserExpense userExpense6=new UserExpense();
        userExpense6.setUserExpenseType(UserExpenseType.PaidBy);
        userExpense6.setAmount(1000);
        userExpense6.setUser(savedUser6);
        UserExpense savedUserExpense6=userExpenseRepository.save(userExpense6);

        Expense expense=new Expense();
        expense.setDescription("Total Trip Expense");
        expense.setAmount(3000);
        expense.setUserExpenses(List.of(savedUserExpense1,savedUserExpense2,
                savedUserExpense3,savedUserExpense4,savedUserExpense5,savedUserExpense6));
        expense.setCurrency(Currency.Rupee);
        Expense savedExpense=expenseRepository.save(expense);

        savedGroup.setExpenses(List.of(savedExpense));
        groupRepository.save(savedGroup);

    }
}

