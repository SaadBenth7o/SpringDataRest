package com.example.tpspringdatarest.controller;

import com.example.tpspringdatarest.feign.AppFeignClient;
import com.example.tpspringdatarest.model.Centre;
import com.example.tpspringdatarest.service.RestTemplateService;
import com.example.tpspringdatarest.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private WebClientService webClientService;

    @Autowired
    private AppFeignClient appFeignClient;

    // --- Centres (RestTemplate) ---
    @GetMapping("/centres")
    public List<Map<String, Object>> getCentres() {
        return restTemplateService.getAllCentres();
    }

    @GetMapping("/centres/{id}")
    public Map<String, Object> getCentre(@PathVariable Long id) {
        return restTemplateService.getCentre(id);
    }

    @PostMapping("/centres")
    public void addCentre(@RequestBody Centre centre) {
        restTemplateService.addCentre(centre);
    }

    @PutMapping("/centres/{id}")
    public void updateCentre(@PathVariable Long id, @RequestBody Centre centre) {
        restTemplateService.updateCentre(id, centre);
    }

    @DeleteMapping("/centres/{id}")
    public void deleteCentre(@PathVariable Long id) {
        restTemplateService.deleteCentre(id);
    }

    // --- Etudiants (Feign) ---
    @GetMapping("/etudiants")
    public List<Map<String, Object>> getEtudiants() {
        Map<String, Object> response = appFeignClient.getAllEtudiants();
        Map<String, Object> embedded = (Map<String, Object>) response.get("_embedded");
        return (List<Map<String, Object>>) embedded.get("etudiants");
    }

    // --- Reactive (WebClient) ---
    @GetMapping("/reactive/centres")
    public Mono<Map> getReactiveCentres() {
        return webClientService.getAllCentres();
    }
}
