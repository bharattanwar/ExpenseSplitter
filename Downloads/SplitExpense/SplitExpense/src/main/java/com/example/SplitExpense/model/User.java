package com.example.SplitExpense.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity(name = "Split_User")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseModel{
    private String name;
    private String email;
    private String PhoneNumber;

    @ManyToMany(mappedBy = "users")
    List<Group> groups;
}
