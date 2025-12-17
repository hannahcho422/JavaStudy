package com.example.demo_spring_security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_spring_security.model.Authority;
import com.example.demo_spring_security.model.Member;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByMember(Member member);
}
