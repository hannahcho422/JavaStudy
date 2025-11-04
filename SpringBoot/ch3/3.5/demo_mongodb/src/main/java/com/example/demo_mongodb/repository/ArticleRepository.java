package com.example.demo_mongodb.repository;

import java.util.List;

import com.example.demo_mongodb.model.Article;

import org.springframework.data.domain.Pageable;                    
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;         
import org.springframework.data.mongodb.repository.Update;       
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

    List<Article> findBy(TextCriteria criteria, Sort sort);
    List<Article> findBy(TextCriteria criteria, Pageable pageable);
    List<Article> findByOrderByScoreDesc(TextCriteria criteria);
    List<Article> findByEmail(String email, TextCriteria criteria, Sort sort);

    // 1st, 2nd 파라미터 각각 이름과 이메일로 검색
    @Query("{name: ?0, email: ?1}")
    List<Article> findByAuthor(String name, String email);

    // @Query 조건으로 검색한 결과에서 
    @Query("{name: ?0}")
    // email을 파라미터로 전달된 값으로 업데이트
    @Update("{$set: {email: ?1}}")
    int updateEmailByName(String name, String email);
}
