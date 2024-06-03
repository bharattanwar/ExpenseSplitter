package com.example.SplitExpense.dto;

import com.example.SplitExpense.model.Group;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;

@Getter
@Setter
public class GroupResponseDTO {
    private String Name;
    private String description;

    public static GroupResponseDTO from(Group group) {
        GroupResponseDTO dto = new GroupResponseDTO();
        dto.Name = group.getGroupName();
        dto.description = group.getDescription();
        return dto;
    }
}
