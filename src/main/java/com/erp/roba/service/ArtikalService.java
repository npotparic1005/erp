package com.erp.roba.service;

import com.erp.roba.exception.ArtikalValidationException;
import com.erp.roba.model.Artikal;
import com.erp.roba.repository.ArtikalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikalService {

        @Autowired
        private ArtikalRepository artikalRepository;

        public List<Artikal> getAllProducts() {
            return artikalRepository.findAll();
        }


    public Artikal addNewProduct(Artikal artikal) throws ArtikalValidationException {
        if (artikal.getSifra() == null || artikal.getNaziv() == null || artikal.getJedinicaMere() == null) {
            throw new ArtikalValidationException("Nedostaju obavezni podaci za artikal.");
        }

        Optional<Artikal> existingArtikalBySifra = artikalRepository.findBySifra(artikal.getSifra());
        if (existingArtikalBySifra.isPresent()) {
            throw new ArtikalValidationException("Artikal sa šifrom " + artikal.getSifra() + " već postoji.");
        }

        return artikalRepository.save(artikal);
    }
}
