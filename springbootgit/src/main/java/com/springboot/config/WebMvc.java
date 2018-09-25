package com.springboot.config;

import com.springboot.controller.interceptor.OneInterceptor;
import com.springboot.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by sunshine on 2018/9/25.
 */
@Configuration
public class WebMvc implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
         registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                 .addPathPatterns("/one/**");

    }
}
