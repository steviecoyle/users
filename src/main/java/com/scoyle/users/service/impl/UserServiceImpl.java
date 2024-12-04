package com.scoyle.users.service.impl;

import com.scoyle.users.dto.CreateUserDto;
import com.scoyle.users.exception.UserNotFoundException;
import com.scoyle.users.persistence.entity.UserEntity;
import com.scoyle.users.persistence.repository.UsersRepository;
import com.scoyle.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
class UserServiceImpl implements UserService {

    private final UsersRepository repository;

    private static final String USER_NOT_FOUND = "User not found";
    private static final String LOG_USER_NOT_FOUND = "User not found for id: {}";

    @Override
    public UserEntity createUser(CreateUserDto userDTO) {
        return repository.save(convertToEntity(userDTO));
    }

    @Override
    public UserEntity updateUser(Long id, CreateUserDto user) throws UserNotFoundException {
        Optional<UserEntity> optionalUserEntity = repository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userToUpdate = convertToEntity(user);
            userToUpdate.setId(id);
            return repository.save(userToUpdate);
        } else {
            log.error(LOG_USER_NOT_FOUND, id);
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        Optional<UserEntity> optionalUserEntity = repository.findById(id);

        if (optionalUserEntity.isPresent()) {
            repository.deleteById(id);
        } else {
            log.error(LOG_USER_NOT_FOUND, id);
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) throws UserNotFoundException {
        Optional<UserEntity> optionalUserEntity = repository.findById(id);

        if (optionalUserEntity.isPresent()) {
            return optionalUserEntity.get();
        } else {
            log.error(LOG_USER_NOT_FOUND, id);
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
    }

    private UserEntity convertToEntity(CreateUserDto userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setForename(userDTO.getForename());
        userEntity.setSurname(userDTO.getSurname());
        userEntity.setUserName(userDTO.getUserName());
        // TODO encrypt password
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setEmailAddress(userDTO.getEmailAddress());
        return userEntity;
    }
}
