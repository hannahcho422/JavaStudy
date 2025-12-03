package com.example.demo_thymeleaf.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo_thymeleaf.model.Member;


@Controller
public class ExpressionController {
    private final List<Member> members = List.of(
        new Member("윤서준", "SeojunYoon@hanbit.co.kr", 10),
        new Member("윤광철", "KwangcheolYoon@hanbiit.co.kr", 43),
        new Member("공미영", "MiyyoengKong@hanbiit.co.kr", 28),
        new Member("김도윤", "DoyunKim@hanbiit.co.kr", 11)
    );

    // 자바 객체 사용
    @GetMapping("/object")
    public String getMember(Model model) {
        model.addAttribute("member", members.getFirst());
        return "expression/object";
    }

    // 유틸리티 객체 사용 - calendars
    @GetMapping("/calendars")
    public String getCalendars(Model model) {
        Date date = Calendar.getInstance().getTime();
        model.addAttribute("date", date);
        return "expression/calendar";
    }
    
    // 유틸리티 객체 사용 - numbers
    @GetMapping("/numbers")
    public String getNumbers(Model model) {
        model.addAttribute("productPrice", 345620.5226);
        model.addAttribute("productCount", 3502340);
        return "expression/numbers";
    }

    // 조건문 사용
    @GetMapping("/condition")
    public String getCondition(Model model) {
        model.addAttribute("showWelcome", true);
        model.addAttribute("showDescription", false);
        return "expression/condition";
    }

    // 반복문 사용
    @GetMapping("/loop")
    public String getMemberList(Model model) {
        model.addAttribute("members", members);
        return "expression/loop";
    }

    
}
