package com.example.demo_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_board.model.Article;
import com.example.demo_board.model.Member;

import jakarta.transaction.Transactional;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    @Transactional
    void deleteAllByMember(Member member);
}
