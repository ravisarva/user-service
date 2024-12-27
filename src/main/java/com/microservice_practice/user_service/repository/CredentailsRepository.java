package com.microservice_practice.user_service.repository;

import com.microservice_practice.user_service.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentailsRepository extends JpaRepository<Credential, Integer> {

}
