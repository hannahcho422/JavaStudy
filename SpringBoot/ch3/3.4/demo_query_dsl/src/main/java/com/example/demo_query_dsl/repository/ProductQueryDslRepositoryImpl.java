package com.example.demo_query_dsl.repository;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.demo_query_dsl.model.Product;
import static com.example.demo_query_dsl.model.QProduct.product;;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductQueryDslRepositoryImpl implements ProductQueryDslRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Product> queryByKeyword(String keyword,
                                        SearchType searchType,
                                        long offset, long limit) {
        var query = jpaQueryFactory.selectFrom(product);

        switch (searchType) {
            case TITLE:
                query = query.where(product.title.contains(keyword));
                break;
            case DESCRIPTION:
                query = query.where(product.description.contains(keyword));
                break;
            case BOTH:
                query = query.where(product.title.contains(keyword)
                        .or(product.description.contains(keyword)));
                break;
        }
        return query
                .orderBy(product.id.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }
}
