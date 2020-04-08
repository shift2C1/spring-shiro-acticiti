//package com.pipichao.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
////https://www.jianshu.com/p/e2d9abb164b6
////@Configuration
//@Slf4j
//public class ShiroConfig {
//    public ShiroConfig(){
//        log.info("初始化shiro配置");
//    }
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//        //绑定安全管理器
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //登录页面
//        shiroFilterFactoryBean.setLoginUrl("login.html");
//        //无权限的跳转页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("403.html");
//        //login success
//        shiroFilterFactoryBean.setSuccessUrl("index.jsp");
//        //自定义过滤器
////        shiroFilterFactoryBean.setFilters();
//
////        过滤器链
//        Map<String,String> filterChain=new LinkedHashMap<>();
////        filterChain.put("login.html","anon");
//        filterChain.put("/app/subLogin","anon1");
//        filterChain.put("/app/**","authc");
////
////        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChain);
//        return shiroFilterFactoryBean;
//    }
//    @Bean(value = "securityManager")
//    public SecurityManager securityManager( ShiroRealm shiroRealm){
//        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
//        //绑定认证及授权的域
//        securityManager.setRealm(shiroRealm);
//        return securityManager;
//    }
//    @Bean("shiroRealm")
//    public ShiroRealm shiroRealm (){
//        ShiroRealm shiroRealm=new ShiroRealm();
//        ///加密算法
//        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
//        //设置加密算法
//        credentialsMatcher.setHashAlgorithmName("md5");//加密方式
//        credentialsMatcher.setHashIterations(1);//加密次数
//        shiroRealm.setCredentialsMatcher(credentialsMatcher);
//        return shiroRealm;
//    }
//
//}
