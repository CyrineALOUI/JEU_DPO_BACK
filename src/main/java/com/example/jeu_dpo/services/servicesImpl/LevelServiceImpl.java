package com.example.jeu_dpo.services.servicesImpl;

import com.example.jeu_dpo.entities.Level;
import com.example.jeu_dpo.repositories.LevelRepository;
import com.example.jeu_dpo.services.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    @Override
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public Level getLevelById(Long id) {
        return levelRepository.findById(id).orElse(null);
    }
}
