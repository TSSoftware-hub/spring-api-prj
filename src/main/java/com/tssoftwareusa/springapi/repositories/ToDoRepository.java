package com.tssoftwareusa.springapi.repositories;

import com.tssoftwareusa.springapi.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {
}