package com.tssoftwareusa.springapi.services;

import com.tssoftwareusa.springapi.entity.ToDoEntity;
import com.tssoftwareusa.springapi.entity.UserEntity;
import com.tssoftwareusa.springapi.model.ToDo;
import com.tssoftwareusa.springapi.repositories.ToDoRepository;
import com.tssoftwareusa.springapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo createToDo(ToDoEntity toDo, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        toDo.setUser(user);
        return ToDo.toModel(toDoRepository.save(toDo));
    }

    public ToDo updateToDo(Long id) {
        ToDoEntity toDo = toDoRepository.findById(id).get();
        toDo.setCompleted(!toDo.isCompleted());
        return ToDo.toModel(toDoRepository.save(toDo));
    }
}