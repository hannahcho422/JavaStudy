package com.example.demo_restful_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_restful_api.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    List<Member> findByNameContainingOrderByNameAsc(String name);
}
