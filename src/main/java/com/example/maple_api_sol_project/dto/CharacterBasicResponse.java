package com.example.maple_api_sol_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CharacterBasicResponse {

    @JsonProperty("character_name")
    private String characterName;

    @JsonProperty("character_level")
    private int characterLevel;

    @JsonProperty("character_class")
    private String characterClass;

    @JsonProperty("character_image")
    private String characterImage;

    @JsonProperty("world_name")
    private String worldName;
}