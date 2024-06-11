package com.example.jeu_dpo.repositories;

import com.example.jeu_dpo.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level,Long>  {
}
