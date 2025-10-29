package com.example.demo_jpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo_jpa.model.Members;
import com.example.demo_jpa.repository.MembersRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class JpaApplication implements ApplicationRunner{
    private final MembersRepository membersRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // membersRepository.save(Members.builder()
        //     .name("윤서준")
        //     .email("SeojunYoon@gmail.com")
        //     .age(10).build());
        // membersRepository.save(Members.builder()
        //     .name("윤광철")
        //     .email("KwangcheolYoon@gmail.com")
        //     .age(43).build());
        var member1 = Members.builder()
            .name("윤서준")
            .email("SeojunYoon@gmail.com")
            .age(10).build();
        log.info("save 윤서준");
        membersRepository.save(member1);
        log.info("saved {}", member1);

        var member2 = Members.builder()
            .name("윤광철")
            .email("KwangcheolYoon@gmail.com")
            .age(43).build();
        log.info("save 윤광철");
        membersRepository.save(member2);
        log.info("saved {}", member1);

        log.info("read 윤서준");
        member1 = membersRepository.findById(member1.getId()).orElseThrow();

        log.info("update 윤서준");
        member1.setAge(11);
        membersRepository.save(member1);
        log.info("updated {}", member1);

        log.info("update 윤광철");
        membersRepository.save(member2);
        log.info("updated {}", member2);

        log.info("애플리케이션 종료");
    }
    
}
