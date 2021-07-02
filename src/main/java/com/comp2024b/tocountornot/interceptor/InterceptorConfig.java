package com.comp2024b.tocountornot.interceptor;

import com.comp2024b.tocountornot.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private final UserService userService;

    public InterceptorConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor());
        registry.addInterceptor(logInterceptor());
    }
    @Bean
    public HandlerInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor(userService);
    }
    @Bean
    public HandlerInterceptor logInterceptor() { return new LogInterceptor(); }
}
