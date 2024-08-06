package com.example.jeu_dpo.controllers;

import com.example.jeu_dpo.entities.Crossword;
import com.example.jeu_dpo.services.CrosswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class CrosswordController {

    private final CrosswordService crosswordService;

    @PostMapping("/addCrossword")
    public ResponseEntity<Crossword> createCrossword(@RequestBody Crossword crossword) {
        Crossword savedCrossword = crosswordService.createCrossword(crossword);
        return ResponseEntity.ok(savedCrossword);
    }

    @GetMapping("/getCrosswordById/{id}")
    public ResponseEntity<Crossword> getCrossword(@PathVariable Long id) {
        return crosswordService.getCrossword(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllCrosswords")
    public ResponseEntity<List<Crossword>> getAllCrosswords() {
        return ResponseEntity.ok(crosswordService.getAllCrosswords());
    }

    @DeleteMapping("/deleteCrossword/{id}")
    public ResponseEntity<Void> deleteCrossword(@PathVariable Long id) {
        crosswordService.deleteCrossword(id);
        return ResponseEntity.noContent().build();
    }
}
