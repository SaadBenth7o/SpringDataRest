package com.example.tpspringdatarest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class UserWebClient {
    private final WebClient webClient = WebClient.create("http://localhost:8080");

    public Mono<Map> getAllUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(Map.class);
    }
}
