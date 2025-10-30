package com.example.demo_jpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo_jpa.model.Article;
import com.example.demo_jpa.model.Members;
import com.example.demo_jpa.repository.MembersRepository;
import com.example.demo_jpa.repository.ArticleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class JpaApplication implements ApplicationRunner {

    private final MembersRepository membersRepository;
    private final ArticleRepository articleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Seed 예시
        // membersRepository.save(Members.builder()
        //     .name("윤서준")
        //     .email("SeojunYoon@gmail.com")
        //     .age(10)
        //     .build());
        // membersRepository.save(Members.builder()
        //     .name("윤광철")
        //     .email("KwangcheolYoon@gmail.com")
        //     .age(43)
        //     .build());

        // 1) member1 저장
        var member1 = Members.builder()
            .name("윤서준")
            .email("SeojunYoon@gmail.com")
            .age(10)
            .build();
        log.info("save 윤서준");
        membersRepository.save(member1);
        log.info("saved {}", member1);

        // 2) article 저장 (변수명 충돌 방지: savedArticle)
        var savedArticle = Article.builder()
            .title("방학 첫날이다")
            .description("오늘은 열심히 방학 숙제를 했다.")
            .member(member1)
            .build();
        articleRepository.save(savedArticle);

        // 3) 전체 게시글 조회 및 로그
        var articles = articleRepository.findAll();
        for (Article a : articles) {
            log.info("{}", a);
        }

        // 4) member2 저장
        var member2 = Members.builder()
            .name("윤광철")
            .email("KwangcheolYoon@gmail.com")
            .age(43)
            .build();
        log.info("save 윤광철");
        membersRepository.save(member2);
        log.info("saved {}", member2);

        // 5) member1 조회 / 수정
        log.info("read 윤서준");
        member1 = membersRepository.findById(member1.getId()).orElseThrow();

        log.info("update 윤서준");
        member1.setAge(11);
        membersRepository.save(member1);
        log.info("updated {}", member1);

        // 6) member2 수정 (현재는 변경 없음 → save 호출만 예시)
        log.info("update 윤광철");
        membersRepository.save(member2);
        log.info("updated {}", member2);

        log.info("애플리케이션 종료");
    }
}