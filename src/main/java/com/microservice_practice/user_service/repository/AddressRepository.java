package com.microservice_practice.user_service.repository;

import com.microservice_practice.user_service.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
