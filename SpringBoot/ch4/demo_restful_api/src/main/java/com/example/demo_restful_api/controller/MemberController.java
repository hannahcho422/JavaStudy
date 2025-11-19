package com.example.demo_restful_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // 회원 조회
    @GetMapping
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    // 아이디로 회원 조회
    @GetMapping("/{id}")
    public Member get(@PathVariable("id") Long id) {
        // findById() 반환 타입: Optional<Member>
        // 데이터베이스에 해당 아이디 갖는 회원 정보 없을 때 orElse(null) 사용해 null 반한하도록 함
        return memberRepository.findById(id).orElse(null);
    }

    // 회원 수정하기
    @PutMapping("/{id}")
    public Member put(@PathVariable("id") Long id, @RequestBody Member member) {
        member.setId(id);
        return memberRepository.save(member);
    }
}