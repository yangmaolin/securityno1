package com.lin.linsecurityno1.security;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/index").setViewName("login.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

    }

    //自定义错误页面
    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new ErrorPageRegistrar(){
            @Override
            public void registerErrorPages(ErrorPageRegistry registry) {
                ErrorPage page403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403.html");//参数是一个控制器请求
                ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
                ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
                registry.addErrorPages(page403, page404, page500);
            }
        };
    }
}
