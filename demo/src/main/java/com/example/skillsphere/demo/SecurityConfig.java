//package com.example.skillsphere.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers("/h2-console/**") // allow POSTs to H2
//                )
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/**", "/h2-console/**").permitAll() // allow auth + H2
//                        .anyRequest().authenticated()
//                )
//                .headers(headers -> headers
//                        .frameOptions().sameOrigin() // allow H2 console frames
//                );
//
//        return http.build();
//    }
//}
//
