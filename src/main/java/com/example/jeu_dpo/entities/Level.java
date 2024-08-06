package com.example.jeu_dpo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy="level")
    @JsonManagedReference
    private List<Game> games;

}
