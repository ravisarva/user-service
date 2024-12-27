package com.microservice_practice.user_service.controller;

import com.microservice_practice.user_service.dto.UserDto;
import com.microservice_practice.user_service.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @NotNull(message = "Input must not be null") @Valid UserDto userDto) {
        var dbUser = userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
    }
}