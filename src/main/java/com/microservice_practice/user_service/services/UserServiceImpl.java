package com.microservice_practice.user_service.services;

import com.microservice_practice.user_service.dto.UserDto;
//import com.microservice_practice.user_service.helper.UserMappingHelper;
import com.microservice_practice.user_service.helper.UserMappingHelper;
import com.microservice_practice.user_service.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        var user = UserMappingHelper.map(userDto);
        var dbUser = userRepository.save(user);
        return null;
    }

    @Override
    public UserDto findById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return List.of();
    }

    @Override
    public UserDto update(Integer userId, UserDto userDto) {
        return null;
    }

    @Override
    public void deletedById(Integer userId) {

    }
}