package com.microservice_practice.user_service.helper;

import org.springframework.beans.BeanUtils;

import com.microservice_practice.user_service.dto.CredentialDto;
import com.microservice_practice.user_service.dto.UserDto;
import com.microservice_practice.user_service.model.Credential;
import com.microservice_practice.user_service.model.User;

public interface UserMappingHelper {

    public static UserDto map(User user) {
        if(user == null) {
            return null;
        }
//        UserDto useDto = new UserDto();
//        BeanUtils.copyProperties(user, useDto);
//
//        if(user.getCredential() != null) {
//            CredentialDto credentialDto = new CredentialDto();
//            BeanUtils.copyProperties(user.getCredential(), credentialDto);
//            useDto.setCredentialDto(credentialDto);
//        }
        return null;
    }

    public static User map(UserDto userDto) {
        if(userDto == null) {
            userDto.getUserId();
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        if(userDto.getCredentialDto() != null) {
            Credential credential = new Credential();
            BeanUtils.copyProperties(userDto.getCredentialDto(),credential);
            credential.setUser(user);
            user.setCredential(credential);
        }
        return user;
    }
}
