package com.pipichao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Configuration
public class MybatisConfig {
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ssm_shiro_activiti?serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("2437262431");
        return druidDataSource;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean (@Autowired DruidDataSource druidDataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        Resource[] resources = new Resource[0];
        try {
            resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/pipichao/dao/*.xml");
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.pipichao.dao");
        return mapperScannerConfigurer;
    }
}
