package com.tssoftwareusa.springapi.model;

import com.tssoftwareusa.springapi.entity.UserEntity;

public class User {
    private Long id;
    private String username;

    public static User toModel (UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setUsername(userEntity.getUsername());

        return model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}