package com.example.demo_jsp_mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo_jsp_mvc.model.Member;

@Controller
public class MemberController {

    private List<Member> members = List.of(
            new Member(1L, "윤서준", "SeojunYoon@hanbiit.co.kr", 10),
            new Member(2L, "윤광철", "KwangcheolYoon@hanbiit.co.kr", 43),
            new Member(3L, "공미영", "MiyyoengKong@hanbiit.co.kr", 21),
            new Member(4L, "김도윤", "DoyunKim@hanbiit.co.kr", 10)
    );

    @GetMapping("/member/list")
    public String getMembers(Model model) {
        model.addAttribute("members", members);
        return "member-list";
    }
}