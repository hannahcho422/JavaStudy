package com.example.demo_restful_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleRequest {
    private String title;
    private String description;
}
