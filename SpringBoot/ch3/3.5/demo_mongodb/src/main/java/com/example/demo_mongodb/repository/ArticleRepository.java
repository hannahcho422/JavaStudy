package com.example.demo_mongodb.repository;

import java.awt.print.Pageable;
import java.util.List;

import com.example.demo_mongodb.model.Article;

import org.springframework.data.mongodb.repository.MongoRepository; 
import org.springframework.stereotype.Repository;    
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findByName(String name);
    List<Article> findByNameAndEmail(String name, String email);
    List<Article> findByNameOrEmail(String name, String email);
    List<Article> findByNameStartingWith(String name);
    List<Article> findByNameEndingWith(String name);
    List<Article> findByNameContaining(String name);
    List<Article> findByNameLike(String name);

    List<Article> findBy(TextCriteria criteria, Sort sort);
    List<Article> findBy(TextCriteria criteria, Pageable pageable);
    List<Article> findByOrderByScoreDesc(TextCriteria criteria);
    List<Article> findByEmail(String email, TextCriteria criteria, Sort sort);
}
