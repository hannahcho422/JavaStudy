package com.example.demo_restful_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_restful_api.dto.MemberRequest;
import com.example.demo_restful_api.dto.MemberResponse;
import com.example.demo_restful_api.exception.NotFoundException;
import com.example.demo_restful_api.model.Member;
import com.example.demo_restful_api.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 생성
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

    // 여러 명 한 번에 생성
    @Transactional
    public List<MemberResponse> createBatch(List<MemberRequest> memberRequests) {
        return memberRequests.stream().map(this::create).toList();
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

    public MemberResponse update(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        // password, enabled 필드 외의 나머지 항목
        member.setName(memberRequest.getName());
        member.setEmail(memberRequest.getEmail());
        member.setAge(memberRequest.getAge());
        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    public MemberResponse patch(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);

        // 전달된 값이 있는 필드만 업데이트
        if (memberRequest.getName() != null)
            member.setName(memberRequest.getName());
        if (memberRequest.getEmail() != null)
            member.setEmail(memberRequest.getEmail());
        if (memberRequest.getAge() != null)
            member.setAge(memberRequest.getAge());

        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    public void deletById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        memberRepository.delete(member);
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