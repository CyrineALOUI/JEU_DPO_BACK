package com.example.jeu_dpo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz extends Game {

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("quiz")
    private List<Question> questions;

}
