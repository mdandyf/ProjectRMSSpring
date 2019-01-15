package com.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

/*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**")
                .addResourceLocations("/react/build/static/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("/react/build/static/js/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("/react/build/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("/react/build/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("/react/build/index.html");
        registry.addResourceHandler("/list.html")
                .addResourceLocations("/react/build/list.html");
    }*/

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/list").setViewName("list");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/list").setViewName("list");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }*/
}
