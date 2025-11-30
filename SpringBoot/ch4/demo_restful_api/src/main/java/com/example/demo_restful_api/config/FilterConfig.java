package com.example.demo_restful_api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo_restful_api.filter.AccessKeyFilter;
import com.example.demo_restful_api.filter.LogFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<LogFilter> logFilter() {
        FilterRegistrationBean<LogFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LogFilter());
        bean.addUrlPatterns("/api/*");
        bean.setOrder(1);
        bean.setName("Log Filter");
        return bean;
    }

    @Bean
    public FilterRegistrationBean<AccessKeyFilter> accessKeyFilter() {
        FilterRegistrationBean<AccessKeyFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new AccessKeyFilter());
        bean.addUrlPatterns("/api/*");
        bean.setOrder(2);
        bean.setName("Access Key Filter");
        return bean;
    }
}
