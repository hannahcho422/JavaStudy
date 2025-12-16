package com.example.demo_spring_security.controller;

import com.example.demo_spring_security.model.Member;

// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private List<Member> members = List.of(
            new Member(1L, "윤서준", "SeojunYoon@hanbit.co.kr", null),
            new Member(2L, "윤광철", "KwangcheolYoon@hanbit.co.kr", null),
            new Member(3L, "공미영", "MiyeongKong@hanbit.co.kr", null),
            new Member(4L, "김도윤", "DoyunKim@hanbit.co.kr", null)
    );

    @GetMapping("/api/members")
    public List<Member> getMembers() {
        return members;
    }
}
