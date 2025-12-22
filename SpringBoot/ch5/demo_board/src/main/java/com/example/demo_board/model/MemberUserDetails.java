package com.example.demo_board.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class MemberUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;

    // Extras
    private final String displayName;
    private final Long memberId;

    public MemberUserDetails(Member member, List<Authority> authorities) {
        this.username = member.getEmail();
        this.displayName = member.getName();
        this.password = member.getPassword();
        this.memberId = member.getId();
        this.authorities = authorities.stream()
                .map(a -> new SimpleGrantedAuthority(a.getAuthority()))
                .map(ga -> (GrantedAuthority) ga)
                .toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}