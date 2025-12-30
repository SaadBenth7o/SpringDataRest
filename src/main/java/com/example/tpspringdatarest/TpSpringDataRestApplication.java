package com.example.tpspringdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TpSpringDataRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TpSpringDataRestApplication.class, args);
    }
}
