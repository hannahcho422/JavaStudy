package com.example.demo_mybatis.model;

import lombok.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String description;
    private Date created;
    private Date updated;
    private Long memberId;
}
