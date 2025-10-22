package com.example.demo_mybatis.mapper;

import com.example.demo_mybatis.model.Members;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MembersMapper {
    List<Members> selectAll();                             // 전체 조회 메서드
    Optional<Members> selectById(@Param("id") Long id);     // 아이디 사용한 조회
    Optional<Members> selectByEmail(@Param("email") String email);
    List<Members> selectAllOrderBy(@Param("order") String order, @Param("dir") String dir);
    List<Members> selectAllOrderBy(@Param("name") String name);
    int selectAllCount();
    int insert(@Param ("members") Members members);
    int update(@Param ("members") Members members);
    int delete(@Param ("members") Members members);
    int deleteById(@Param("id") Long id);
    int deleteAll();
}
