package com.example.tpspringdatarest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Service
public class WebClientService {
    private final WebClient webClient = WebClient.create("http://localhost:8080");

    public Mono<Map> getAllCentres() {
        return webClient.get().uri("/centres").retrieve().bodyToMono(Map.class);
    }

    public Mono<Map> getAllEtudiants() {
        return webClient.get().uri("/etudiants").retrieve().bodyToMono(Map.class);
    }
}
