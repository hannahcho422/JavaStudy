package com.example.demo_crud_repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Table("members")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Members {
    @Id
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
