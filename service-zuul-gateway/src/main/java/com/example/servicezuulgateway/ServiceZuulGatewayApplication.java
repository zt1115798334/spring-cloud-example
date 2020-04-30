package com.example.servicezuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhang
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ServiceZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulGatewayApplication.class, args);
    }

}
