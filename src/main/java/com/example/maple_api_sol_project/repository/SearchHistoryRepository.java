package com.example.maple_api_sol_project.repository;

import com.example.maple_api_sol_project.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
}