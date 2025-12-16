package com.example.demo_spring_security.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo_spring_security.model.Member;

@Controller
@Slf4j
public class MemberController {
    private List<Member> members = List.of(
            new Member(1L, "윤서준", "SeojunYoon@hanbiit.co.kr", null),
            new Member(2L, "윤광철", "KwangcheolYoon@hanbiit.co.kr", null),
            new Member(3L, "공미영", "MiyyoengKong@hanbiit.co.kr", null),
            new Member(4L, "김도윤", "DoyunKim@hanbiit.co.kr", null)
    );

    @GetMapping("/member/list")
    public String getMembers(Model model) {
        model.addAttribute("members", members);
        return "/member-list";
    }
}
