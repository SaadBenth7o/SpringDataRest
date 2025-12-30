package com.example.tpspringdatarest.config;

import com.example.tpspringdatarest.model.Centre;
import com.example.tpspringdatarest.model.Etudiant;
import com.example.tpspringdatarest.repository.CentreRepository;
import com.example.tpspringdatarest.repository.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner initData(CentreRepository centreRepository, EtudiantRepository etudiantRepository) {
        return args -> {
            Centre centre1 = new Centre(null, "Centre Maamora", "Salé", null);
            Centre centre2 = new Centre(null, "Centre Rabat", "Rabat", null);
            centreRepository.saveAll(Arrays.asList(centre1, centre2));

            Etudiant et1 = new Etudiant(null, "Ali", "Ahmed", "Homme", centre1);
            Etudiant et2 = new Etudiant(null, "Sara", "Karim", "Femme", centre1);
            Etudiant et3 = new Etudiant(null, "Mohamed", "Amine", "Homme", centre2);
            Etudiant et4 = new Etudiant(null, "Heba", "Nour", "Femme", centre2);
            etudiantRepository.saveAll(Arrays.asList(et1, et2, et3, et4));
        };
    }
}
