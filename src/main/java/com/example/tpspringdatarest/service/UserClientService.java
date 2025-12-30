package com.example.tpspringdatarest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserClientService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8080/users";

    public List<Map<String, Object>> getAllUsers() {
        // Warning: This works if the server is up. Since this is the same app,
        // it works as long as the app is running.
        Map response = restTemplate.getForObject(BASE_URL, Map.class);
        return (List<Map<String, Object>>) ((Map) response.get("_embedded")).get("users");
    }
}
