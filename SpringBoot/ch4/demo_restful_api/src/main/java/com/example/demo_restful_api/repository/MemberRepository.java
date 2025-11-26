package com.example.demo_restful_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo_restful_api.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    List<Member> findByNameContainingOrderByNameAsc(String name);
    List<Member> findByName(String name);
    List<Member> findByNameAndEmail(String name, String email);
    List<Member> findByNameOrEmail(String name, String eamil);
    List<Member> findByNameContaining(String name);
    List<Member> findByNameLike(String name);
    // List<Member> findByAgeIs(Integer age);
    // List<Member> findByAgeIsNull();
    // List<Member> findByAgeIsNotNull();
    List<Member> findByAgeGreaterThan(Integer age);
    List<Member> findByAgeGreaterThanEqual(Integer age);
    List<Member> findByAgeLessThan(Integer age);
    List<Member> findByAgeLessThanEqual(Integer age);

    // JPA Query Methods for ORDER BY
    List<Member> findAllByOrderByNameAsc();

    // JPQL (Java Persistence Query Language)
    @Query("SELECT m FROM Member m WHERE m.name = :name")
    List<Member> findMemberByName(@Param("name") String name);
    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.email = :email")
    List<Member> findMemberByNameEmail(@Param("name") String name, @Param("email") String email);


}
