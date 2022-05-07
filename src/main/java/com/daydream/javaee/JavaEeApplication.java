package com.daydream.javaee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@ServletComponentScan({"jsp.controller","jsp.filter","jsp.listener","jsp.controller"})
@MapperScan
@SpringBootApplication
public class JavaEeApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JavaEeApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(JavaEeApplication.class, args);
    }

}
