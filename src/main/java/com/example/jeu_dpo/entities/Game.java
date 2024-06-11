package com.example.jeu_dpo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="game_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ASSOCIATIONS */
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

}
