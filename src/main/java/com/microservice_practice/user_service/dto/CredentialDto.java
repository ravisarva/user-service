package com.microservice_practice.user_service.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.microservice_practice.user_service.model.RoleBasedAuthrority;

import com.microservice_practice.user_service.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class CredentialDto implements Serializable {

    private Integer credentialId;
    private String username;

    private String password;

    private RoleBasedAuthrority roleBasedAuthrority;

    private Boolean isEnabled;

    private Boolean isAccountNonExpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentailsNonExpired;

    @JsonProperty("user")
    @JsonInclude(value = Include.NON_NULL)
    private UserDto userDto;

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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
