package com.example.demo_mybatis.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo_mybatis.model.Article;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ArticleMapper {
    // select
    @Results(id = "articleResult", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "title", column = "title"),
        @Result(property = "description", column = "content"),
        @Result(property = "memberId", column = "member_id"),
        @Result(property = "created", column = "created"),
        @Result(property = "updated", column = "updated")
    })
    @Select("SELECT * FROM article")
    List<Article> selectAll();   

    @ResultMap("articleResult")
    @Select("SELECT * FROM article WHERE id=#{id}")
    Optional<Article> selectById(@Param("id") Long id);

    @ResultMap("articleResult")
    @Select("SELECT * FROM article WHERE member_id=#{memberId}")
    List<Article> selectByMemberId(@Param("memberId") Long memberId);

    @Select("SELECT COUNT(*) FROM article")
    int selectAllCount();

    // insert
    @Insert("""
        INSERT INTO article(title, description, created, updated, member_id)
        VALUES(#{article.title}, #{article.description}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, #{article.memberId})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("article") Article article);

    // update
    @Update("""
        UPDATE article
            SET title=#{title}, description=#{description}, updated=CURRENT_TIMESTAMP WHERE id=#{id}
    """)
    int update(@Param("id") Long id, @Param("title") String title, @Param("description") String description);

    // delete
    @Delete("DELETE article WHERE id=#{id}")
    int deleteById(@Param("id") Long id);

    @Delete("DELETE article WHERE member_id=#{memberId}")
    int deleteByMemberId(@Param("memberId") Long memberId);

    @Delete("DELETE article")
    int deleteAll();
}
