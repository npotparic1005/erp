package com.erp.roba.repository;

import com.erp.roba.model.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtikalRepository extends JpaRepository<Artikal, Long> {
    Optional<Artikal> findBySifra(String sifra);
}
