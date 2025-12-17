package com.example.demo_spring_security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

// JDBC 
@Configuration
public class SecurityConfiguration {
    @Bean
    UserDetailsManager userDetailsManagerJdbc(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


// @Configuration
// public class SecurityConfiguration {
//     // 메모리 기반
//     @Bean
//     public UserDetailsService userDetailsServiceInMemory() {
//         UserDetails user = User.builder()
//                 .username("user")
//                 .password("{noop}password")
//                 .roles("USER")
//                 .build();
//         UserDetails admin = User.builder()
//                 .username("admin")
//                 .password("{noop}password")
//                 .roles("USER", "ADMIN")
//                 .build();
//         return new InMemoryUserDetailsManager(user, admin);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

// }
