package com.example.demo_restful_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_restful_api.dto.ArticleResponse;
import com.example.demo_restful_api.service.ArticleService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    // 전체 게시글 목록 조회
    @GetMapping
    public List<ArticleResponse> getByMember(@RequestParam(name="memberId", required=false) Long memberId) {
        if (memberId == null) {
            return articleService.findAll();
        } else {
            return articleService.findByMemberId(memberId);
        }
    }

    // 게시글 아이디 사용해 게시글 조회
    @GetMapping("/{id}")
    public ArticleResponse get(@PathVariable("id") Long id) {
        return articleService.findById(id);
    }    
}
