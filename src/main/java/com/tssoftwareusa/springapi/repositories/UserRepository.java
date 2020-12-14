package com.tssoftwareusa.springapi.repositories;

import com.tssoftwareusa.springapi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String userName);
}