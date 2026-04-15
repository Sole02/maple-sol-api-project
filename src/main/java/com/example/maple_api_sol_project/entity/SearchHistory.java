package com.example.maple_api_sol_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String characterName;
    private String searchType;
    private String ipAddress;
    private LocalDateTime searchedAt;

    public SearchHistory(String characterName, String searchType, String ipAddress) {
        this.characterName = characterName;
        this.searchType = searchType;
        this.ipAddress = ipAddress;
        this.searchedAt = LocalDateTime.now();
    }
}