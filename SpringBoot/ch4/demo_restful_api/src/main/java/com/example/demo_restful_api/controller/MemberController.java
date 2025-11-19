package com.example.demo_restful_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_restful_api.model.Member;  
import com.example.demo_restful_api.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    // 회원 생성
    @PostMapping
    public Member post(@RequestBody Member member) {
        // 클라이언트로부터 전달받은 Member 객체 데베에 저장
        // .save()가 반환한 Member 객체 -> 자동 생성 기본 키 포함
        // 클라이어느에게 다시 반환
        return memberRepository.save(member);  
    }
}