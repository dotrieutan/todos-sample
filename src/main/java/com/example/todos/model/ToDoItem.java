package com.example.todos.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "to_do_item")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @Column(nullable = false)
    String description;

    @Enumerated(EnumType.STRING)
    ToDoStatus status;

    @Column(nullable = false)
    LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
