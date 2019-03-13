package com.ecommerce.member;

import com.ecommerce.member.model.ApiKeyMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class MemberApplication implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ApiKeyMethodArgumentResolver());
    }

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }

}
