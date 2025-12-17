package com.example.demo_spring_security.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.example.demo_spring_security.model.Authority;
import com.example.demo_spring_security.model.Member;
import com.example.demo_spring_security.model.MemberUserDetails;
import com.example.demo_spring_security.repository.AuthorityRepository;
import com.example.demo_spring_security.repository.MemberRepository;

@Configuration
public class SecurityConfiguration {

    @Bean
    PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        return repository;
    }

    @Bean
    RememberMeServices rememberMeServices(
                UserDetailsService userDetailsService, 
                PersistentTokenRepository tokenRepository) {
        return new PersistentTokenBasedRememberMeServices(
            "myRememberKey", 
            userDetailsService, 
            tokenRepository);
    }

    /**
     * Security Filter Chain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(
                HttpSecurity http, RememberMeServices rememberMeServices) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // .requestMatchers("/", "/home").permitAll()
                // .requestMatchers("/member/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
            )
            // .rememberMe(withDefaults())
            .rememberMe(remember -> remember
                .rememberMeServices(rememberMeServices))
            .formLogin(withDefaults())
            .logout(withDefaults());

        return http.build();
    }

    /**
     * Custom UserDetailsService (DB 기반)
     */
    @Bean
    public UserDetailsService userDetailsService(
            MemberRepository memberRepository,
            AuthorityRepository authorityRepository
    ) {
        return username -> {
            Member member = memberRepository.findByEmail(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found: " + username));

            List<Authority> authorities = authorityRepository.findByMember(member);

            return new MemberUserDetails(member, authorities);
        };
    }

    /**
     * Password Encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* =========================================================
     * In-Memory 기반 인증 (비활성화)
     * =========================================================
     */
//    @Bean
//    public UserDetailsService userDetailsServiceInMemory() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}password")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}password")
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    /* =========================================================
     * JDBC 기반 인증 (비활성화)
     * =========================================================
     */
//    @Bean
//    public UserDetailsManager userDetailsManagerJdbc(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
}