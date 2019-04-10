package com.map.mapdemo;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * Demo class
 *
 * @author ypc
 * @date 2019/4/09
 */
@SpringBootApplication
@ComponentScan("com.map.mapdemo")
@MapperScan("com.map.mapdemo.mapper")
public class MapDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapDemoApplication.class, args);
    }

//    @Bean(destroyMethod = "close", initMethod = "init")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }

}