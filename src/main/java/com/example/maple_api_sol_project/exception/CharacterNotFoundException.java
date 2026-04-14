package com.example.maple_api_sol_project.exception;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(String characterName) {
        super(characterName + "은(는) 존재하지 않는 캐릭터입니다.");
    }
}