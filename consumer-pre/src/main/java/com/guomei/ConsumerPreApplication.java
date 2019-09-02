package com.guomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//开启Feign支持
@EnableFeignClients
public class ConsumerPreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerPreApplication.class, args);
    }

}
