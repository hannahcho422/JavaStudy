package com.example.demo_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members", indexes = {
    @Index(name = "idx_name_age", columnList = "name, age"),
    @Index(name = "idx_email", columnList = "email")
})
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Colum(name="display_name")
    private String name;
    //@Column(name="primary_contact")
    private String email;
    private Integer age;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Article> articles;
}
