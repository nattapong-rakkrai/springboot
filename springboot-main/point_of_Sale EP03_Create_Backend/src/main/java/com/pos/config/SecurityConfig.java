package com.pos.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import
        org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {
        http
// ปิ ด CSRF เพราะเราก าลังสร้าง REST API
                .csrf(csrf -> csrf.disable())
// REST API ไม่ใช้ Session
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )
// กา หนดสิทธิ์การเข้าถึง
                .authorizeHttpRequests(auth -> auth
// อนุญาตให้ทดสอบ Role API ได้โดยไม่ต้อง Login
                                .requestMatchers("/api/roles/**").permitAll()
// ส่วนอื่น ๆ ต้อง Authentication
                                .anyRequest().authenticated()
                );
        return http.build();
    }
}