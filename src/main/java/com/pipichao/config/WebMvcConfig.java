//package com.pipichao.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import java.util.List;
//
//@EnableWebMvc
//@ComponentScan(basePackages = "com.pipichao")
//@ImportResource("classpath:spring-context.xml")
//@EnableAspectJAutoProxy
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
//        viewResolver.setPrefix("/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////
////    }
//}
