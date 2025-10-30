package com.example.demo_jpa.repository;

import com.example.demo_jpa.model.Article;
import com.example.demo_jpa.model.Members;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    List<Article> findByMember(Members member);
}
