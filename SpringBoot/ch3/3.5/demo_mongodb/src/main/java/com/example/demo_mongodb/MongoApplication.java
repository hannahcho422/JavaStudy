package com.example.demo_mongodb;

import java.util.List;

import com.example.demo_mongodb.model.Article;
import com.example.demo_mongodb.repository.ArticleRepository;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class MongoApplication implements ApplicationRunner {
    private final ArticleRepository articleRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        TextCriteria criteria = TextCriteria
                            .forDefaultLanguage()
                            .matchingAny("제주", "성산일출봉", "바다");
        List<Article> result = articleRepository.findByOrderByScoreDesc(criteria);
        result.forEach(article -> log.info("article={}", article));

        // 게시글 작성자 이름 찾아서 이메일 주소 바꾸기, 이름과 이메일로 게시글 조회
        int count = articleRepository.updateEmailByName("윤서준", "SeojunYoon@campus.co.kr");
        log.info("count={}", count);

        var result2 = articleRepository.findByAuthor("윤서준", "SeojunYoon@campus.co.kr");
        result2.forEach(article -> log.info("article={}, article")); 
    }
}
