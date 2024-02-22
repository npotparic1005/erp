package com.erp.roba.service;

import com.erp.roba.model.Artikal;
import com.erp.roba.repository.ArtikalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikalService {

        @Autowired
        private ArtikalRepository artikalRepository;

        public List<Artikal> getAllProducts() {
            return artikalRepository.findAll();
        }

}
