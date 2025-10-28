package com.example.demo_jpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo_jpa.model.Members;
import com.example.demo_jpa.repository.MembersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class JpaApplication implements ApplicationRunner{
    private final MembersRepository membersRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        membersRepository.save(Members.builder()
            .name("윤서준")
            .email("SeojunYoon@gmail.com")
            .age(10).build());
        membersRepository.save(Members.builder()
            .name("윤광철")
            .email("KwangcheolYoon@gmail.com")
            .age(43).build());
    }
    
}
