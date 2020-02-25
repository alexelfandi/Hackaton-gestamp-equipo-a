package com.gestamp.proyecto.ventas.auth;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class JWTServerApplication {


    public static void main(String[] args) {
            SpringApplication.run(JWTServerApplication.class, args);
        }

        @Bean
        public FilterRegistrationBean corsFilter() {
            final CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.addAllowedOrigin("*");
            config.addAllowedHeader("*");
            config.addAllowedMethod("*");
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);
            final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
            bean.setOrder(0);
            return bean;
        }
    }

