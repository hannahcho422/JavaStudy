package com.example.demo_board.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo_board.dto.MemberDto;
import com.example.demo_board.model.Member;
import com.example.demo_board.repository.ArticleRepository;
import com.example.demo_board.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDto findById(Long id) {
        return memberRepository.findById(id).map(this::mapToMemberDto).orElseThrow();
    }

    private MemberDto mapToMemberDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}
