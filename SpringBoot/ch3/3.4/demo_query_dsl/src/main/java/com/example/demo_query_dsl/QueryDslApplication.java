package com.example.demo_query_dsl;

import java.util.List;

import org.springframework.boot.ApplicationArguments;   
import org.springframework.boot.ApplicationRunner;   
import org.springframework.stereotype.Component;

import com.example.demo_query_dsl.model.Product;
import com.example.demo_query_dsl.repository.ProductRepository;
import com.example.demo_query_dsl.repository.ProductQueryDslRepository; 

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class QueryDslApplication implements ApplicationRunner {
    private final ProductRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var product1 = Product.builder()
                .title("애플 워치")
                .description("애플의 스마트 워치")
                .build();
        var product2 = Product.builder()
                .title("갤럭시 워치")
                .description("삼성의 스마트 워치")
                .build(); 
        var product3 = Product.builder()
                .title("샤오미 워치")
                .description("샤오미의 스마트 워치")
                .build(); 
        var product4 = Product.builder()
                .title("캠퍼스 워치")
                .description("캠퍼스의 스마트 워치")
                .build();      
        var products = List.of(product1, product2, product3, product4);
        repository.saveAll(products);

        var result = repository.queryByKeyword("캠퍼스", 
                    ProductQueryDslRepository.SearchType.TITLE, 
                    0, 
                    10);
        log.info("result: {}", result);
        
    }
    
}
