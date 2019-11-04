package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author 33755
 */
@SpringBootApplication
@MapperScan("com.springboot.mapper")
public class FileApplication {

    //*跨域处理*//*
    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //*允许任何域名使用*//*
        corsConfiguration.addAllowedOrigin("*");
        //*允许任何头*//*
        corsConfiguration.addAllowedHeader("*");
        //*允许任何方法*//*
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    //*跨域过滤器*//*
    @Bean
    public CorsFilter coreFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

}
