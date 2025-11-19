package com.example.demo_restful_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_restful_api.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    
}
