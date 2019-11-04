package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/22 - 10:18
 * @description ：静态资源配置类
 */

@Configuration
@EnableWebMvc
public class StaticResourcesConfig implements WebMvcConfigurer {

    /**
     * 路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当前项目静态资源注册
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

         //  http://localhost:8080/resources/a.jpg   就可以访问下面的图片
        registry.addResourceHandler("/resources/**").addResourceLocations("file:D:/uploads/images/");

    }
}
