package com.scoyle.users.service;

import com.scoyle.users.dto.CreateUserDto;
import com.scoyle.users.exception.UserNotFoundException;
import com.scoyle.users.persistence.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser(CreateUserDto userDTO);

    UserEntity updateUser(Long id, CreateUserDto user) throws UserNotFoundException;

    void deleteUser(Long id) throws UserNotFoundException;

    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long id) throws UserNotFoundException;
}
