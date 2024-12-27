package com.microservice_practice.user_service.services;

import com.microservice_practice.user_service.dto.UserDto;
import com.microservice_practice.user_service.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);
    UserDto findById(Integer userId);
    List<UserDto> findAll();
    UserDto update(Integer userId, UserDto userDto);
    void deletedById(Integer userId);

}
