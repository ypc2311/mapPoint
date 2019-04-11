package com.map.mapdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Demo class
 *
 * @author ypc
 * @date 2019/4/09
 */
@SpringBootApplication
@MapperScan("com.map.mapdemo.mapper")
public class MapDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapDemoApplication.class, args);
    }
}
