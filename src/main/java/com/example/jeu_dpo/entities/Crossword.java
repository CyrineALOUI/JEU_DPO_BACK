package com.example.jeu_dpo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crossword extends Game {

    private int gridSize;

    @OneToMany(mappedBy = "crossword", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("crossword")
    private List<Word> words = new ArrayList<>();

}
