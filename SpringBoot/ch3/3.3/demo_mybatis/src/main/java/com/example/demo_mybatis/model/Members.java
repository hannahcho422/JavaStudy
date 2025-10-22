package com.example.demo_mybatis.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Members {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
