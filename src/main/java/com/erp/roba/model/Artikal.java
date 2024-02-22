package com.erp.roba.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artikli")
public class Artikal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

//    private String sifraArtikla;

//    private String jedinicaMere;

//    private Double marza;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<NabavnaCena> nabavneCene;

    // Getters and setters...
}