package com.example.demo_spring_security.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo_spring_security.model.Authority;
import com.example.demo_spring_security.model.Member;
import com.example.demo_spring_security.repository.AuthorityRepository;
import com.example.demo_spring_security.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (memberRepository.count() == 0) {
            Member user = memberRepository.save(Member.builder()
                .name("윤서준")
                .email("SeojunYoon@hanbit.co.kr")
                .password(passwordEncoder.encode("password")).build());
            Member admin = memberRepository.save(Member.builder()
                .name("윤광철")
                .email("KwangcheolYoon@hanbit.co.kr")
                .password(passwordEncoder.encode("password")).build());
            authorityRepository.save(Authority.builder().authority("ROLE_USER").member(user).build());
            authorityRepository.save(Authority.builder().authority("ROLE_USER").member(admin).build());
            authorityRepository.save(Authority.builder().authority("ROLE_ADMIN").member(admin).build());
        }
    }
}
