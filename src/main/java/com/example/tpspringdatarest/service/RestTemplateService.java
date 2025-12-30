package com.example.tpspringdatarest.service;

import com.example.tpspringdatarest.model.Centre;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class RestTemplateService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8080";

    // --- Centres ---
    public List<Map<String, Object>> getAllCentres() {
        Map response = restTemplate.getForObject(BASE_URL + "/centres", Map.class);
        return (List<Map<String, Object>>) ((Map) response.get("_embedded")).get("centres");
    }

    public Map<String, Object> getCentre(Long id) {
        return restTemplate.getForObject(BASE_URL + "/centres/" + id, Map.class);
    }

    public void addCentre(Centre centre) {
        restTemplate.postForObject(BASE_URL + "/centres", centre, Centre.class);
    }

    public void updateCentre(Long id, Centre centre) {
        restTemplate.put(BASE_URL + "/centres/" + id, centre);
    }

    public void deleteCentre(Long id) {
        restTemplate.delete(BASE_URL + "/centres/" + id);
    }

    // --- Etudiants ---
    public List<Map<String, Object>> getAllEtudiants() {
        Map response = restTemplate.getForObject(BASE_URL + "/etudiants", Map.class);
        return (List<Map<String, Object>>) ((Map) response.get("_embedded")).get("etudiants");
    }
}
