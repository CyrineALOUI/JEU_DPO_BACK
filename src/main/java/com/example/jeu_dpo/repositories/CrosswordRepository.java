package com.example.jeu_dpo.repositories;

import com.example.jeu_dpo.entities.Crossword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrosswordRepository extends JpaRepository<Crossword,Long> {
}
