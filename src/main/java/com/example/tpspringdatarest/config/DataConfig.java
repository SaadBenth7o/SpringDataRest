package com.example.tpspringdatarest.config;

import com.example.tpspringdatarest.model.User;
import com.example.tpspringdatarest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            User user1 = new User(0, "Mohammed", "mhd@mail.com");
            User user2 = new User(0, "Moad", "moad@mail.com");
            User user3 = new User(0, "Sana", "sana@mail.com");
            User user4 = new User(0, "Ahlam", "ahlam@mail.com");
            userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
        };
    }
}
