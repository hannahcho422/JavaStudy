package com.example.demo_board.service;

import org.springframework.stereotype.Service;

import com.example.demo_board.dto.ArticleDto;
import com.example.demo_board.model.Article;
import com.example.demo_board.repository.ArticleRepository;
import com.example.demo_board.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    private ArticleDto mapToArticleDto(Article article) {
        return ArticleDto.builder()
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
