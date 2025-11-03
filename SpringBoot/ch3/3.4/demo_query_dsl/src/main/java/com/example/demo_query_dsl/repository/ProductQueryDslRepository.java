package com.example.demo_query_dsl.repository;

import java.util.List;

import com.example.demo_query_dsl.model.Product;

public interface ProductQueryDslRepository {
    enum SearchType {
        TITLE,
        DESCRIPTION,
        BOTH
    }
    List<Product> queryByKeyword(String keyword,
                                 SearchType searchType,
                                 long offset, long limit);
    
}
