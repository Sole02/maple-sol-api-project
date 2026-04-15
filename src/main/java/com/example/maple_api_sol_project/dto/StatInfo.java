package com.example.maple_api_sol_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StatInfo {

    @JsonProperty("stat_name")
    private String statName;

    @JsonProperty("stat_value")
    private String statValue;
}