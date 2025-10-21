package com.example.demo_crud_repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo_crud_repo.Members;

@Repository
public interface MembersRepository extends CrudRepository<Members, Long> {
    // 기본적인 CRUD 메서드(save, findById, findAll, deleteById) 자동 제공
}
