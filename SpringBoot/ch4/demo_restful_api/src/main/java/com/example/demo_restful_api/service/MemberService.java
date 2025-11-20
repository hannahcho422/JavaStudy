package com.example.demo_restful_api.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_restful_api.dto.MemberRequest;
import com.example.demo_restful_api.dto.MemberResponse;
import com.example.demo_restful_api.exception.NotFoundException;
import com.example.demo_restful_api.model.Member;
import com.example.demo_restful_api.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse create(MemberRequest memberRequest) {
        Member member = Member.builder()
                .name(memberRequest.getName())
                .email(memberRequest.getEmail())
                .age(memberRequest.getAge())
                .enabled(true)
                .build();
        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    public List<MemberResponse> findAll() {
        // List<Member> members = memberRepository.findAll();
        // List<MemberResponse> memberResponses = new ArrayList<>();
        // for (Member member : members) {
        //     MemberResponse memberResponse = mapToMemberResponse(member);
        //     memberResponses.add(memberResponse);
        // }
        // return memberResponses;
        return memberRepository
            .findAll()
            .stream()
            .map(this::mapToMemberResponse)
            .toList();
    }

    public MemberResponse findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapToMemberResponse(member);
    }

    private MemberResponse mapToMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .age(member.getAge())
                .build();
    }
}