package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
//因为缺少DataSource配置文件，则防止此类自动注入
@EnableAutoConfiguration
//(exclude= {DataSourceAutoConfiguration.class})
//@ComponentScan主要就是定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
@ComponentScan(basePackages="com.example")
@MapperScan({"com.example.**.dao"})
public class LeaveServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveServerApplication.class, args);
	}

}

