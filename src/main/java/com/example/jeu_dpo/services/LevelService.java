package com.example.jeu_dpo.services;

import com.example.jeu_dpo.entities.Level;
import java.util.List;

public interface LevelService {

    public List<Level> getAllLevels();
    public Level getLevelById(Long id);

}
