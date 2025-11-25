package com.example.demo_restful_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_restful_api.dto.ArticleRequest;
import com.example.demo_restful_api.dto.ArticleResponse;
import com.example.demo_restful_api.exception.NotFoundException;
import com.example.demo_restful_api.model.Article;
import com.example.demo_restful_api.model.Member;
import com.example.demo_restful_api.repository.ArticleRepository;
import com.example.demo_restful_api.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    // 게시글 작성
    public ArticleResponse create(Long memberId, ArticleRequest articleRequest) {
        Member member = memberRepository.findById(memberId).orElseThrow(NotFoundException::new);
        Article article = Article.builder() 
                    .title(articleRequest.getTitle())
                    .description(articleRequest.getDescription())
                    .member(member).build();
        articleRepository.save(article);
        return mapToArticleResponse(article);
    }

    // 전체 게시글 목록 조회
    public List<ArticleResponse>findAll() {
        return articleRepository.findAll()
                .stream()
                .map(this::mapToArticleResponse)
                .toList();
    }

    // 특정 회원 게시글 목록 조회
    public List<ArticleResponse> findByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(NotFoundException::new);
        return articleRepository.findByMember(member)
                .stream()
                .map(this::mapToArticleResponse)
                .toList();
    }

    // 게시글 아이디 사용해서 게시글 조회
    public ArticleResponse findById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapToArticleResponse(article);
    }

    // 게시글 아이디 사용해서 게시글 수정
    public ArticleResponse update(Long id, ArticleRequest articleRequest) {
        Article article = articleRepository.findById(id).orElseThrow(NotFoundException::new);
        article.setTitle(articleRequest.getTitle());
        article.setDescription(articleRequest.getDescription());
        articleRepository.save(article);
        return mapToArticleResponse(article);
    }
    
    // 게시글 아이디 사용해서 게시글 삭제
    public void delete(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(NotFoundException::new);
        articleRepository.delete(article);
    }

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
