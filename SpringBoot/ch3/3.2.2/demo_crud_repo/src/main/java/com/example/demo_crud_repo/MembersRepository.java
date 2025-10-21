package com.example.demo_crud_repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo_crud_repo.Members;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;     
import org.springframework.data.repository.query.Param; 

@Repository
public interface MembersRepository extends CrudRepository<Members, Long> {
    // 기본적인 CRUD 메서드(save, findById, findAll, deleteById) 자동 제공

    // 쿼리 메서드 기능
    List<Members> findByName(String name);
    List<Members> findByEmail(String email);
    List<Members> findByNameContaining(String name);

    // And Or
    List<Members> findByNameAndEmail(String name, String email);
    List<Members> findByNameOrEmail(String name, String email);

    // 숫자 컬럼 크기 비교 메서드
    List<Members> findByAgeGreaterThan(int age);
    List<Members> findByAgeLessThan(int age);
    List<Members> findByAgeBetween(int min, int max);

    // @Query 
    @Query("SELECT * FROM members WHERE age >= 13 AND age <= 19")
    List<Members> findTeenAge();

    @Query("SELECT * FROM members WHERE age >= :min AND age <= :max")
    List<Members>findByAgeRange(int min, int max);
}
