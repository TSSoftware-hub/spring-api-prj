package com.tssoftwareusa.springapi.controller;

import com.tssoftwareusa.springapi.entity.ToDoEntity;
import com.tssoftwareusa.springapi.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDoEntity
            , @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDo(toDoEntity, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred!");
        }
    }

    @PutMapping
    public ResponseEntity updateToDo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.updateToDo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred!");
        }
    }
}