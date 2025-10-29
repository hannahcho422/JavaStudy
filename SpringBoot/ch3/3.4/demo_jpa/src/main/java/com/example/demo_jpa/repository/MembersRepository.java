package com.example.demo_jpa.repository;

import com.example.demo_jpa.model.Members;
import com.example.demo_jpa.model.MemberStats; 

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long>{
    // 이름으로 회원 조회
    List<Members> findAllByName(String name);
    List<Members> findByName(String name);
    List<Members> findByNameIs(String name);
    List<Members> findByNameEquals(String name);

    // find 이외에도 get, query, read, search 사용 가능
    List<Members> getByName(String name);
    List<Members> queryByName(String name);
    List<Members> readByName(String name);
    List<Members> searchByName(String name);

    // 이름과 이메일을 AND 조건으로 회원 조회
    List<Members> findByNameAndEmail(String name, String email);

    // 이름과 이메일을 OR 조건으로 회원 조회
    List<Members> findByNameOrEmail(String name, String email);

    // 이름의 시작으로 회원 조회
    List<Members> findByNameStartingWith(String name);

    // 이름의 마지막으로 회원 조회
    List<Members> findByNameEndingWith(String name);

    // 이름을 포함하는 회원 조회
    List<Members> findByNameContaining(String name);

    // 이름을 포함하는 회원 조회로 LIKE 검색 위한 와일드카드 %를 매개변수에 포함
    List<Members> findByNameLike(String name);

    // 나이 정보 존재하지 않는 회원 조회
    List<Members> findByAgeIsNull();

    // 나이 정보 존재하는 회원 조회
    List<Members> findByAgeIsNotNull();

    // 매개변수로 전달된 나이로 회원 조회
    List<Members> findByAgeIs(Integer age);

    // 매개변수로 전달된 나이보다 나이가 더 많은 회원 조회
    List<Members> findByAgeGreaterThan(Integer age);
    List<Members> findByAgeAfter(Integer age);

    // 매개변수로 전달된 나이보다 나이가 더 많거나 같은 회원 조회
    List<Members> findByAgeGreaterThanEqual(Integer age); 

    // 매개변수로 전달된 나이보다 나이가 더 적은 회원 조회
    List<Members> findByAgeLessThan(Integer age);
    List<Members> findByAgeBefore(Integer age);

    // 매개변수로 전달된 나이보다 나이가 더 적거나 같은 회원 조회
    List<Members> findByAgeLessThanEqual(Integer age); 

    // 매개변수로 전달된 나이를 포함해 그 사이 나이의 회원 조회
    List<Members> findByAgeBetween(Integer min, Integer max); 

    // 이름순으로 조회
    List<Members> findByOrderByNameAsc(); 

    // 이름 역순으로 조회
    List<Members> findByOrderByNameDesc(); 

    // 이름순으로 조회하고 이름이 같은 경우에는 나이의 역순으로 조회
    List<Members> findByOrderByNameAscAgeDesc(); 

    // 이름의 일부로 검색하고 그 결과는 이름순으로 조회
    List<Members> findByNameContainingOrderByNameAsc(String name); 

    // 나이순으로 정렬하고 나이가 가장 적은 한 명을 조회
    Members findFirstByOrderByAgeAsc();
    Members findTopByOrderByAgeAsc();

    // 나이순으로 정렬하고 나이가 가장 적은 두 명을 조회
    List<Members> findFirst2ByOrderByAgeAsc();
    List<Members> findTop2ByOrderByAgeAsc();

    // 이름의 일부분으로 검색하고 Sort 객체 정보 기반으로 정렬
    List<Members> findByNameContaining(String name, Sort sort);

    // 이름의 일부분으로 검색하고 Pageable 객체 정보 기반으로 페이지 조회
    Page<Members> findByNameContaining(String name, Pageable pageable);

    // 이메일 사용해 회원 삭제
    @Transactional
    int deleteByEmail(String email);

    // 이름 사용해 회원 삭제
    @Transactional
    int deleteByName(String name);

    @Query("SELECT m FROM Members m WHERE m.name = :name")
    List<Members> findMember(@Param("name") String name);

    @Query("SELECT m FROM Members m WHERE m.name = :name AND m.email = :email")
    List<Members> findMember(@Param("name") String name, @Param("email") String email);

    @Query("""
            SELECT m.name, m.email, COUNT(a.id) as count
            FROM Members m LEFT JOIN Article a ON a.member = m
            GROUP BY m ORDER BY count DESC
    """)
    List<Object[]> getMemberStatsObject();

    @Query("""
            SELECT new com.example.demo_jpa.model.MemberStats(m.name, m.email, COUNT(a.id) as count)
            FROM Members m LEFT JOIN Article a ON a.member = m
            GROUP BY m ORDER BY count DESC
    """)
    List<MemberStats> getMemberStats();

    @Modifying
    @Query("UPDATE Members m SET m.age = :age")
    @Transactional
    int setMemberAge(Integer age);

}
