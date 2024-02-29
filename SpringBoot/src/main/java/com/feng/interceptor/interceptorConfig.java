package com.feng.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class interceptorConfig implements WebMvcConfigurer {
    //过滤器 implements WebMvcConfigurer
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login","/findblogs","/user/checkusername","/user/regist");
        //过滤和不过滤
    }

    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
}
