package com.example.todos.repository.spec;

import com.example.todos.dto.ToDoItemFilterDto;
import com.example.todos.model.Customer;
import com.example.todos.model.ToDoItem;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ToDoItemSpecification implements Specification<ToDoItem> {

    private ToDoItemFilterDto toDoItemFilterDto;

    public ToDoItemSpecification(ToDoItemFilterDto toDoItemFilterDto) {
        this.toDoItemFilterDto = toDoItemFilterDto;
    }

    @Override
    public Predicate toPredicate(Root<ToDoItem> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (!toDoItemFilterDto.getCustomerId().isEmpty()) {
            Join<ToDoItem, Customer> customerJoin = root.join("customer");
            predicates.add(criteriaBuilder.equal(
                    customerJoin.get("id"),
                    toDoItemFilterDto.getCustomerId().get()));
        }

        if (!toDoItemFilterDto.getStatus().isEmpty()) {
            predicates.add(criteriaBuilder.equal(
                    root.get("status"), toDoItemFilterDto.getStatus()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
