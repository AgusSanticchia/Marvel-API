package com.test.api.persistance.entity;

import lombok.Data;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    private boolean enabled;

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role == null) return new ArrayList<>();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add( new SimpleGrantedAuthority(role.getAuthority()));

        if(role.getPermissions() == null) return authorities;

        role.getPermissions().stream()
                .forEach( each -> {
                    String permissionName = each.getPermission().getName();
                    authorities.add(new SimpleGrantedAuthority(permissionName));
                });
        return authorities;
    }
}