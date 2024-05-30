package com.example.jeu_dpo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Level implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String levelNumber;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    /* ASSOCIATIONS */
    @ManyToOne
    Player player;
}
