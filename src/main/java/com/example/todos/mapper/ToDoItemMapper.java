package com.example.todos.mapper;

import com.example.todos.dto.ToDoItemDto;
import com.example.todos.model.ToDoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface ToDoItemMapper {

    ToDoItemDto toDoItemToToDoItemDto(ToDoItem toDoItem);

    List<ToDoItemDto> toDoItemsToToDoItemDtos(List<ToDoItem> toDoItem);

    @Mapping(target = "id", ignore = true)
    ToDoItem toDoItemDtoToToDoItem(ToDoItemDto toDoItemDto);
}
