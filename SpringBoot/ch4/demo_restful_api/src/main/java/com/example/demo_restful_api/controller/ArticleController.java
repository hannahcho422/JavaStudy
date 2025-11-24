package com.example.demo_restful_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_restful_api.dto.ArticleRequest;
import com.example.demo_restful_api.dto.ArticleResponse;
import com.example.demo_restful_api.service.ArticleService;
import com.example.demo_restful_api.service.MemberService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ArticleController {
    private final MemberService memberService;
    private final ArticleService articleService;

    @PostMapping("/{id}/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponse postArticle(@PathVariable("id") Long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.create(id, articleRequest);
    }
    
}
