package com.erp.roba.controller;

import com.erp.roba.model.Artikal;
import com.erp.roba.service.ArtikalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
