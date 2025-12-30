package com.example.tpspringdatarest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface UserFeignClient {

    @GetMapping(value = "/users", produces = "application/json")
    Map<String, Object> getAllUsers();
}
