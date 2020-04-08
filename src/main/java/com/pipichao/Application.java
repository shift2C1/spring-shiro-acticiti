//package com.pipichao;
//
//import com.pipichao.config.WebMvcConfig;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.*;
//import java.util.EnumSet;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Application implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext webApplicationContext =new AnnotationConfigWebApplicationContext();
//        webApplicationContext.register(WebMvcConfig.class);
//        webApplicationContext.setServletContext(servletContext);
//        webApplicationContext.refresh();
////        webmvc
//        DispatcherServlet dispatcherServlet=new DispatcherServlet();
//        dispatcherServlet.setApplicationContext(webApplicationContext);
//        ServletRegistration.Dynamic mvcServlet = servletContext.addServlet("mvcServlet", dispatcherServlet);
//        mvcServlet.setLoadOnStartup(1);
//        mvcServlet.addMapping("/app/*");
////        shiro过滤器(使用spring的代理过滤器):
//        DelegatingFilterProxy delegatingFilterProxy =new DelegatingFilterProxy();
//        //使用 代理过滤器代理名字叫 shiroFilter 的一个过滤器
//        FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("shiroFilter", delegatingFilterProxy);
//        //这里可能会出错DispatcherType
//        shiroFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),false,"/*");
//
//    }
//}
