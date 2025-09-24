package com.example.demo_jdbc;

// 데이터베이스와 테이블 조회 결과 담을 자바 객체
// 테이블에서 관리하는 컬럼에 1:1 매핑해 id, name, email, age 프로퍼티 갖도록 선언
public class Members {
    private Long id;
    private String name;
    private String email;
    private Integer age;

    public Members(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // 모든 프로퍼티 내용 출력
    public String toString() {
        return "Members(id=" + id + ", name=" + name + ", email=" + email + ", age=" + age +")";
    }
}
