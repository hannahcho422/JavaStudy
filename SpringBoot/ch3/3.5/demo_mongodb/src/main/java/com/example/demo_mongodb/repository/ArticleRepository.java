package com.example.demo_mongodb.repository;

import java.util.List;

import com.example.demo_mongodb.model.Article;

import org.springframework.data.mongodb.repository.MongoRepository; 
import org.springframework.stereotype.Repository;    

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findByName(String name);
    List<Article> findByNameAndEmail(String name, String email);
    List<Article> findByNameOrEmail(String name, String email);
    List<Article> findByNameStartingWith(String name);
    List<Article> findByNameEndingWith(String name);
    List<Article> findByNameContaining(String name);
    List<Article> findByNameLike(String name);
}
