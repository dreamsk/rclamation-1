package com.reclamation.rservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RServiceApplication.class, args);
    }

}
