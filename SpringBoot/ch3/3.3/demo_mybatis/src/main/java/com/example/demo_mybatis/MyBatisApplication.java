package com.example.demo_mybatis;

import org.springframework.stereotype.Component;
import com.example.demo_mybatis.mapper.MembersMapper;
import com.example.demo_mybatis.mapper.ArticleMapper;
import com.example.demo_mybatis.model.Members;
import com.example.demo_mybatis.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class MyBatisApplication implements ApplicationRunner {
    private final MembersMapper membersMapper;
    private final ArticleMapper articleMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int count = membersMapper.selectAllCount();
        log.info("Members count: {}", count);

        Members members = membersMapper
            .selectByEmail("SeojunYoon@gmail.com")
            .orElseThrow();
        log.info("Members: {}", members);

        Article article = Article.builder()
            .title("Hello, MyBatis")
            .description("MyBatis is an SQL Mapper framework")
            .memberId(members.getId())
            .build();
        int inserted = articleMapper.insert(article);
        log.info("Inserted: {}", inserted);
    }
    
}
