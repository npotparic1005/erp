package com.erp.roba.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "artikli")
public class Artikal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String sifra;

    @NotNull
    private String naziv;

    @NotNull
    private String jedinicaMere;

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }
}