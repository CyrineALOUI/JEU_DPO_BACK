package com.example.jeu_dpo.controllers;

import com.example.jeu_dpo.entities.Level;
import com.example.jeu_dpo.services.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/listLevels")
    public ResponseEntity<List<Level>> getAllLevels() {
        List<Level> levels = levelService.getAllLevels();
        return ResponseEntity.ok(levels);
    }

    @GetMapping("/getLevel/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable Long id) {
        Level level = levelService.getLevelById(id);
        return ResponseEntity.ok(level);
    }
}
