package com.microservice_practice.user_service.controller;

import com.microservice_practice.user_service.dto.UserDto;
import com.microservice_practice.user_service.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
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

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable Integer userId) {
//        log.info("UserController :: fetch user details");
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable Integer userId,
                                          @RequestBody UserDto userDto ) {
//        log.info("UserController :: update");
        return ResponseEntity.ok(userService.update(userId, userDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer userId) {
//        log.info("UserController :: Delete");
        userService.deleteById(userId);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String username) {
//        log.info("UserController :: findByUsername");
        return ResponseEntity.ok(userService.findByUsername(username));
    }
}