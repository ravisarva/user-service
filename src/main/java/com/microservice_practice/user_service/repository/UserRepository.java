package com.microservice_practice.user_service.repository;

import java.util.Optional;

import com.microservice_practice.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByCredentialUsername(String username);
}
