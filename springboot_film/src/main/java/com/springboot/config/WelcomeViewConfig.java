package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/10 - 14:29
 * @description ：
 */
@Configuration
public class WelcomeViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");    //经过模板引擎解析，跳转页面
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }




   /* *//**
     * 新增额外的静态资源文件夹
     * @param registry
     *//*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/imgs/");

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }*/
}
