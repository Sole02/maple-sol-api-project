package com.example.maple_api_sol_project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class MapleApiConfig {

    @Value("${maple.api.key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setInterceptors(List.of((request, body, execution) -> {
            request.getHeaders().set("x-nxopen-api-key", apiKey);
            return execution.execute(request, body);
        }));

        return restTemplate;
    }
}