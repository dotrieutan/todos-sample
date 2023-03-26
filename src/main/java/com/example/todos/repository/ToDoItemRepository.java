package com.example.todos.repository;

import com.example.todos.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long>,
        JpaSpecificationExecutor<ToDoItem> {
}
