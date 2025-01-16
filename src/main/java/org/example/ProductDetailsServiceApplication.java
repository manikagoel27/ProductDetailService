package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProductDetailsServiceApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProductDetailsServiceApplication.class);
        springApplication.run(args);
    }
}