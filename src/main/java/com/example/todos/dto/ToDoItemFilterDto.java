package com.example.todos.dto;

import com.example.todos.model.ToDoStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoItemFilterDto {
    Optional<Long> customerId;

    Optional<ToDoStatus> status;
}
