package com.chinasoftinternational.uav;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

@ComponentScan(value = "com.chinasoftinternational.uav")
@MapperScan(value = "com.chinasoftinternational.uav.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class UavApplication implements TransactionManagementConfigurer {

    @Resource(name="txManager")
    private PlatformTransactionManager txManager;

    // 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(UavApplication.class, args);
    }

}
