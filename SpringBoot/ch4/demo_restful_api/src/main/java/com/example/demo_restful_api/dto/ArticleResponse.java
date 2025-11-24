package com.example.demo_restful_api.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleResponse {
    private Long id;
    private Long memberId;
    private String name;
    private String email;
    private String title;
    private String description;
    private Date created;
    private Date updated; 
}
