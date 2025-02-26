package com.example.tutorialUpload.model.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false)
    private String cognome;
    private String avatarProfilo;


}
