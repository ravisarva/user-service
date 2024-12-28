package com.microservice_practice.user_service.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credential implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="credential_id",unique = true,nullable = false)
	private Integer credentialId;

	@Column(unique = true)
	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private RoleBasedAuthrority roleBasedAuthrority;

	private Boolean isEnabled;

	private Boolean isAccountNonExpired;

	private Boolean isAccountNonLocked;

	private Boolean isCredentailsNonExpired;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable = false)
	private User user;

	public Integer getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleBasedAuthrority getRoleBasedAuthrority() {
		return roleBasedAuthrority;
	}

	public void setRoleBasedAuthrority(RoleBasedAuthrority roleBasedAuthrority) {
		this.roleBasedAuthrority = roleBasedAuthrority;
	}

	public Boolean getEnabled() {
		return isEnabled;
	}

	public void setEnabled(Boolean enabled) {
		isEnabled = enabled;
	}

	public Boolean getAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		isAccountNonExpired = accountNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		isAccountNonLocked = accountNonLocked;
	}

	public Boolean getCredentailsNonExpired() {
		return isCredentailsNonExpired;
	}

	public void setCredentailsNonExpired(Boolean credentailsNonExpired) {
		isCredentailsNonExpired = credentailsNonExpired;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
