package com.example.demo_board.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo_board.model.Authority;
import com.example.demo_board.model.Member;
import com.example.demo_board.model.MemberUserDetails;
import com.example.demo_board.repository.AuthorityRepository;
import com.example.demo_board.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));

        List<Authority> authorities = authorityRepository.findByMember(member);

        return new MemberUserDetails(member, authorities);
    }
}