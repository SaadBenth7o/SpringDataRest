package com.example.tpspringdatarest.feign;

import com.example.tpspringdatarest.model.Centre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "app-service", url = "http://localhost:8080")
public interface AppFeignClient {

    @GetMapping(value = "/centres", produces = "application/json")
    Map<String, Object> getAllCentres();

    @GetMapping(value = "/centres/{id}", produces = "application/json")
    Centre getCentre(@PathVariable("id") Long id);

    @GetMapping(value = "/etudiants", produces = "application/json")
    Map<String, Object> getAllEtudiants();
}
