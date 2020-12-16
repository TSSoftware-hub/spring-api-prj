package com.tssoftwareusa.springapi.model;

import com.tssoftwareusa.springapi.entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean completed;

    public static ToDo toModel(ToDoEntity toDoEntity) {
        ToDo model = new ToDo();
        model.setId(toDoEntity.getId());
        model.setTitle(toDoEntity.getTitle());
        model.setCompleted(toDoEntity.isCompleted());
        return model;
    }

    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}