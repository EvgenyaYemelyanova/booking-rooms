package com.example.bookingrooms.model;

import com.example.bookingrooms.model.permission.Permission;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {

    ADMIN(Set.of(
            Permission.CREATE,
            Permission.READ,
            Permission.UPDATE,
            Permission.DELETE,
            Permission.WRITE)),
    MANAGER(Set.of(
            Permission.READ,
            Permission.UPDATE,
            Permission.DELETE)),
    USER(Set.of(
            Permission.READ,
            Permission.WRITE));
    private final Set<Permission> permissions;
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
