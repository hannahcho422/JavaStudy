package com.example.demo_crud_repo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringJdbcApplication implements ApplicationRunner {
    private final MembersRepository membersRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // create
        Members members = Members.builder().name("정혁").email("HyeokJung@gmail.com").age(10).build();
        membersRepository.save(members);

        // update
        members.setAge(11);
        membersRepository.save(members);
    }
    
}
