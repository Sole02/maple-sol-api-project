package com.example.maple_api_sol_project.service;

import com.example.maple_api_sol_project.dto.CharacterBasicResponse;
import com.example.maple_api_sol_project.dto.CharacterOcidResponse;
import com.example.maple_api_sol_project.dto.CharacterStatResponse;
import com.example.maple_api_sol_project.entity.SearchHistory;
import com.example.maple_api_sol_project.exception.CharacterNotFoundException;
import com.example.maple_api_sol_project.repository.SearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final RestTemplate restTemplate;
    private final SearchHistoryRepository searchHistoryRepository;

    @Value("${maple.api.base-url}")
    private String baseUrl;

    public String getOcid(String characterName) {
        try {
            String url = baseUrl + "/maplestory/v1/id?character_name=" + characterName;
            CharacterOcidResponse response = restTemplate.getForObject(url, CharacterOcidResponse.class);
            return response.getOcid();
        } catch (Exception e) {
            throw new CharacterNotFoundException(characterName);
        }
    }

    public CharacterBasicResponse getCharacterBasic(String characterName, String ipAddress) {
        searchHistoryRepository.save(new SearchHistory(characterName, "BASIC", ipAddress));
        String ocid = getOcid(characterName);
        String url = baseUrl + "/maplestory/v1/character/basic?ocid=" + ocid;
        return restTemplate.getForObject(url, CharacterBasicResponse.class);
    }

    public CharacterStatResponse getCharacterStat(String characterName, String ipAddress) {
        searchHistoryRepository.save(new SearchHistory(characterName, "STAT", ipAddress));
        String ocid = getOcid(characterName);
        String url = baseUrl + "/maplestory/v1/character/stat?ocid=" + ocid;
        return restTemplate.getForObject(url, CharacterStatResponse.class);
    }
}