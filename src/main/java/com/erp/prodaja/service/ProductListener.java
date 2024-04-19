package com.erp.prodaja.service;

import com.erp.roba.model.Artikal;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProductListener {

    @RabbitListener(queues = "productQueue")
    public void processNewProduct(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Artikal artikal = objectMapper.readValue(json, Artikal.class);

        System.out.println("Primljen je novi artikal: " + artikal.getNaziv() + " (" + artikal.getSifra() + ")");
    }
}
