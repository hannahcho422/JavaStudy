package com.example.demo_spring_security.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import com.example.demo_spring_security.model.Authority;
import com.example.demo_spring_security.model.Member;
import com.example.demo_spring_security.model.MemberUserDetails;
import com.example.demo_spring_security.repository.AuthorityRepository;
import com.example.demo_spring_security.repository.MemberRepository;

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

    @Bean 
    public UserDetailsService userDetailsServiceCustom2(
        MemberRepository memberRepository,
        AuthorityRepository authorityRepository) {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Member member = memberRepository.findByEmail(username).orElseThrow();
                List<Authority> authorities = authorityRepository.findByMember(member);

                return new MemberUserDetails(member, authorities);
            }
        
        };
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
