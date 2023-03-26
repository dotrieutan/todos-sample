package com.example.todos.controller;

import com.example.todos.dto.CustomerDto;
import com.example.todos.dto.ToDoItemDto;
import com.example.todos.dto.ToDoItemFilterDto;
import com.example.todos.service.ToDoItemService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoItemController {

    final ToDoItemService toDoItemService;

    @GetMapping("/customers/{id}/todoitems")
    public List<ToDoItemDto> getToDoItem(@PathVariable Long id) {
        return toDoItemService.getToDoItems(
                ToDoItemFilterDto.builder()
                        .customerId(Optional.of(id))
                        .build());
    }

    @PostMapping("/customers/{id}/todoitems")
    public ResponseEntity<ToDoItemDto> createToDoItem(@PathVariable Long id,
                                                      @RequestBody ToDoItemDto toDoItemDto) {
        toDoItemDto.setCustomer(CustomerDto.builder().id(id).build());
        ToDoItemDto result = toDoItemService.createToDoItem(toDoItemDto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
