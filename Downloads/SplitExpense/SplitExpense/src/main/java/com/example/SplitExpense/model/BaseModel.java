package com.example.SplitExpense.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;
}
