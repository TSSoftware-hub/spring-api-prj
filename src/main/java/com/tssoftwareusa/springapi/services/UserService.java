package com.tssoftwareusa.springapi.services;

import com.tssoftwareusa.springapi.entity.UserEntity;
import com.tssoftwareusa.springapi.exceptions.UserAlreadyExistsException;
import com.tssoftwareusa.springapi.exceptions.UserNotFoundException;
import com.tssoftwareusa.springapi.model.User;
import com.tssoftwareusa.springapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistsException("User with this name already exists!");
        }
        return userRepository.save(userEntity);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User with this id wasn't found!");
        }

        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);

        return id;
    }
}