package com.example.todos.dto;

import com.example.todos.model.ToDoStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoItemDto {
    String description;
    ToDoStatus status;
    LocalDateTime createdDate;
    CustomerDto customer;
}
