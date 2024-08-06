package com.example.jeu_dpo.services;

import com.example.jeu_dpo.entities.Crossword;
import java.util.List;
import java.util.Optional;

public interface CrosswordService {

    public Crossword createCrossword(Crossword crossword);
    public Optional<Crossword> getCrossword(Long id);
    public List<Crossword> getAllCrosswords();
    public void deleteCrossword(Long id);

}
