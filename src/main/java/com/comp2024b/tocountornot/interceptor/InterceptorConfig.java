package com.comp2024b.tocountornot.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor());
        registry.addInterceptor(logInterceptor());
    }
    @Bean
    public HandlerInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    @Bean
    public HandlerInterceptor logInterceptor() { return new LogInterceptor(); }
}
