package com.example.maple_api_sol_project.controller;

import com.example.maple_api_sol_project.dto.CharacterBasicResponse;
import com.example.maple_api_sol_project.dto.CharacterStatResponse;
import com.example.maple_api_sol_project.service.CharacterService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<CharacterBasicResponse> getCharacter(
            @PathVariable String name,
            HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        CharacterBasicResponse character = characterService.getCharacterBasic(name, ip);
        return ResponseEntity.ok(character);
    }

    @GetMapping("/{name}/stat")
    public ResponseEntity<CharacterStatResponse> getCharacterStat(
            @PathVariable String name,
            HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        CharacterStatResponse stat = characterService.getCharacterStat(name, ip);
        return ResponseEntity.ok(stat);
    }
}