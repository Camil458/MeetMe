package com.meetme.meetme.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserDTO implements UserDetails {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private Boolean locked;
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public UserDTO(String username, String email, String password, Role role, Boolean locked, Boolean enabled) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.locked = locked;
        this.enabled = enabled;
    }
}
