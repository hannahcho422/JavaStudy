package com.example.demo_board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_board.model.Authority;
import com.example.demo_board.model.Member;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByMember(Member member);
}
