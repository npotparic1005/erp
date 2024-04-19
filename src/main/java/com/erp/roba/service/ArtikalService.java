package com.erp.roba.service;

import com.erp.roba.exception.ArtikalValidationException;
import com.erp.roba.model.Artikal;
import com.erp.roba.repository.ArtikalRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikalService {

    @Autowired
    private ArtikalRepository artikalRepository;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue productQueue;

    public List<Artikal> getAllProducts() {
        return artikalRepository.findAll();
    }


    public Artikal addNewProduct(Artikal artikal) throws ArtikalValidationException, JsonProcessingException {
        if (artikal.getSifra() == null || artikal.getNaziv() == null || artikal.getJedinicaMere() == null) {
            throw new ArtikalValidationException("Nedostaju obavezni podaci za artikal.");
        }

        Optional<Artikal> existingArtikalBySifra = artikalRepository.findBySifra(artikal.getSifra());
        if (existingArtikalBySifra.isPresent()) {
            throw new ArtikalValidationException("Artikal sa šifrom " + artikal.getSifra() + " već postoji.");
        }

        Artikal savedArtikal = artikalRepository.save(artikal);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(artikal);

        rabbitTemplate.convertAndSend(productQueue.getName(), json);

        return savedArtikal;
    }
}
