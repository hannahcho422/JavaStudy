package com.example.demo_restful_api.service;

import org.springframework.stereotype.Service;

import com.example.demo_restful_api.dto.ArticleResponse;
import com.example.demo_restful_api.model.Article;
import com.example.demo_restful_api.repository.ArticleRepository;
import com.example.demo_restful_api.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    private ArticleResponse mapToArticleResponse(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .created(article.getCreated())
                .updated(article.getUpdated())
                .memberId(article.getMember().getId())
                .name(article.getMember().getName())
                .email(article.getMember().getEmail())
                .build();
    }
}
