package com.example.demo_board.model;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberUserDetails implements UserDetails {
    // UserDetails default 구현 : getUsername(), getPassword(), getAuthorities()
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;

    // Extras
    private String displayName;
    private Long memberId;

    public MemberUserDetails(Member member, List<Authority> authorities) {
        this.username = member.getEmail();
        this.displayName = member.getName();
        this.password = member.getPassword();
        this.memberId = member.getId();
        this.authorities = authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .toList();
    }
}
