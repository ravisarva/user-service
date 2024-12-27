package com.microservice_practice.user_service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum RoleBasedAuthrority {

	ROLE_USER("USER"),
	ROLE_ADMIN("ADMIN");

	private final String role;

	RoleBasedAuthrority(String role) {
		this.role = role;
	}
}
