package com.example.tpspringdatarest.controller;

import com.example.tpspringdatarest.feign.UserFeignClient;
import com.example.tpspringdatarest.service.UserClientService;
import com.example.tpspringdatarest.service.UserWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private UserClientService userClientService;

    @Autowired
    private UserWebClient userWebClient;

    @Autowired
    private UserFeignClient userFeignClient;

    // RestTemplate
    @GetMapping("/users/resttemplate")
    public List<Map<String, Object>> getUsersViaRestTemplate() {
        return userClientService.getAllUsers();
    }

    // WebClient
    @GetMapping("/users/webclient")
    public Mono<Map> getUsersViaWebClient() {
        return userWebClient.getAllUsers();
    }

    // Feign
    @GetMapping("/users/feign")
    public List<Map<String, Object>> getUsersViaFeign() {
        Map<String, Object> response = userFeignClient.getAllUsers();
        Map<String, Object> embedded = (Map<String, Object>) response.get("_embedded");
        return (List<Map<String, Object>>) embedded.get("users");
    }
}
