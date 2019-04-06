package com.apt.project4.config;

import com.apt.project4.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private Long id;

    private String userName;

    private String typeRole;

    private boolean active;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String username, String password, String typeRole, Collection<? extends GrantedAuthority> authorities, boolean active) {
        this.id = id;
        this.userName = username;
        this.password = password;
        this.typeRole = typeRole;
        this.authorities = authorities;
        this.active = active;

    }

    public static UserPrincipal create(User user) {
        String roleName = user.getRole().getRoleName();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roleName));

        return new UserPrincipal(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                roleName,
                authorities,
                user.isActive()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public boolean isActive() {
        return active;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
