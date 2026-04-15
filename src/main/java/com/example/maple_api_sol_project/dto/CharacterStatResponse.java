package com.example.maple_api_sol_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CharacterStatResponse {

    @JsonProperty("date")
    private String date;

    @JsonProperty("character_class")
    private String characterClass;

    @JsonProperty("final_stat")
    private List<StatInfo> finalStat;

    @JsonProperty("remain_ap")
    private Long remainAp;
}