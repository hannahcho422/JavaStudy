package com.example.demo_restful_api.service;

import org.springframework.stereotype.Service;

import com.example.demo_restful_api.dto.MemberResponse;
import com.example.demo_restful_api.repository.MemberRepository;
import com.example.demo_restful_api.model.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private MemberResponse mapToMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .age(member.getAge())
                .build();
    }
    
}
