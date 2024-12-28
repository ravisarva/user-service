package com.microservice_practice.user_service.services;

import com.microservice_practice.user_service.dto.UserDto;
//import com.microservice_practice.user_service.helper.UserMappingHelper;
import com.microservice_practice.user_service.helper.UserMappingHelper;
import com.microservice_practice.user_service.model.Credential;
import com.microservice_practice.user_service.model.User;
import com.microservice_practice.user_service.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        var user = UserMappingHelper.map(userDto);
        var dbUser = userRepository.save(user);
        return UserMappingHelper.map(dbUser);
    }

    @Override
    public UserDto findById(Integer userId) {
        return userRepository.findById(userId).map(UserMappingHelper::map)
                .orElseThrow(() -> new RuntimeException("User not found Exception."));
    }

    @Override
    public List<UserDto> findAll() {
//        log.info("UserServiceImpl :: findAll");
        return userRepository.findAll()
                .stream()
                .map(UserMappingHelper::map)
                .collect(Collectors.toUnmodifiableList());
    }
    @Override
    public UserDto update(Integer userId, UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getUserId()).orElseThrow(() -> new RuntimeException("Invalid user id"));
        BeanUtils.copyProperties(userDto, existingUser,"credential");
        if(userDto.getCredentialDto() != null) {
            Credential credentail = existingUser.getCredential();
            if(credentail == null) {
                credentail = new Credential();
                existingUser.setCredential(credentail);
            }
            BeanUtils.copyProperties(userDto.getCredentialDto(), credentail);
        }
        User updatedUser = userRepository.save(existingUser);

        return UserMappingHelper.map(updatedUser);
    }
    @Override
    public void deleteById(Integer userId) {
//        log.info("UserServiceImpl :: deleteById");
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto findByUsername(String username) {
//        log.info("UserService :: findByUsername");
        return UserMappingHelper.map(
                userRepository.findByCredentialUsername(username)
                        .orElseThrow(() -> new RuntimeException("User Not Found")));
    }
}