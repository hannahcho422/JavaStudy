package com.example.demo_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo_jpa.model.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long>{
    
}
