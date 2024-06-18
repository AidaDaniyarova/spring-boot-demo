package com.spring.java.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN;
    @Override
    public String getAuthority() {
        return name();
    }
}
