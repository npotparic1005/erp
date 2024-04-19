package com.erp.roba.controller;

import com.erp.roba.exception.ArtikalValidationException;
import com.erp.roba.model.Artikal;
import com.erp.roba.service.ArtikalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artikli")
public class ArtikalController {

    @Autowired
    private ArtikalService artikalService;

    @GetMapping
    public ResponseEntity<List<Artikal>> getAllProducts() {
        List<Artikal> artikli = artikalService.getAllProducts();
        return ResponseEntity.ok(artikli);
    }

    @PostMapping
    public ResponseEntity<Artikal> addNewProduct(@RequestBody Artikal artikal) throws JsonProcessingException {
        Artikal savedArtikal = artikalService.addNewProduct(artikal);
        return ResponseEntity.ok(savedArtikal);
    }
}
