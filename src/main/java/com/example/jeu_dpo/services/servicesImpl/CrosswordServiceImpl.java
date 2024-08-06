package com.example.jeu_dpo.services.servicesImpl;

import com.example.jeu_dpo.entities.Crossword;
import com.example.jeu_dpo.entities.Word;
import com.example.jeu_dpo.repositories.CrosswordRepository;
import com.example.jeu_dpo.repositories.WordRepository;
import com.example.jeu_dpo.services.CrosswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrosswordServiceImpl implements CrosswordService {

    private final CrosswordRepository crosswordRepository;
    private final WordRepository wordRepository;

    public Crossword createCrossword(Crossword crossword) {
        crossword = crosswordRepository.save(crossword);
        for (Word word : crossword.getWords()) {
            word.setCrossword(crossword);
            wordRepository.save(word);
        }
        return crossword;
    }

    public Optional<Crossword> getCrossword(Long id) {
        return crosswordRepository.findById(id);
    }

    public List<Crossword> getAllCrosswords() {
        return crosswordRepository.findAll();
    }

    public void deleteCrossword(Long id) {
        crosswordRepository.deleteById(id);
    }
}
