package com.example.todos.service;

import com.example.todos.dto.ToDoItemDto;
import com.example.todos.dto.ToDoItemFilterDto;
import com.example.todos.exception.DataNotFoundException;
import com.example.todos.mapper.ToDoItemMapper;
import com.example.todos.model.Customer;
import com.example.todos.model.ToDoItem;
import com.example.todos.repository.CustomerRepository;
import com.example.todos.repository.ToDoItemRepository;
import com.example.todos.repository.spec.ToDoItemSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoItemService {

    final ToDoItemRepository toDoItemRepository;

    final CustomerRepository customerRepository;

    final ToDoItemMapper toDoItemMapper;

    public List<ToDoItemDto> getToDoItems(ToDoItemFilterDto toDoItemFilterDto) {
        Specification<ToDoItem> weatherSpec =
                new ToDoItemSpecification(toDoItemFilterDto);
        List<ToDoItem> models = toDoItemRepository.findAll(
                weatherSpec,
                Sort.by(Sort.Direction.DESC, "createdDate"));

        return toDoItemMapper.toDoItemsToToDoItemDtos(models);
    }

    @Transactional
    public ToDoItemDto createToDoItem(ToDoItemDto toDoItemDto) {
        Optional<Customer> customer = customerRepository.findById(
                toDoItemDto.getCustomer().getId());
        if (customer.isEmpty()) {
            throw new DataNotFoundException();
        }

        ToDoItem toDoItem = toDoItemMapper.toDoItemDtoToToDoItem(toDoItemDto);
        toDoItem.setCustomer(customer.get());

        return toDoItemMapper.toDoItemToToDoItemDto(
                toDoItemRepository.save(toDoItem));
    }
}
