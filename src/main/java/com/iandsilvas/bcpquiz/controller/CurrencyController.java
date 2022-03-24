package com.iandsilvas.bcpquiz.controller;

import com.iandsilvas.bcpquiz.domain.Currency;
import com.iandsilvas.bcpquiz.payload.request.ChangeDTO;
import com.iandsilvas.bcpquiz.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/currency", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {

    Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping()
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Currency>> getAllChanges() {
        List<Currency> currencies = new ArrayList<Currency>();
        currencyRepository.findAll().forEach(currencies::add);
        return new ResponseEntity<List<Currency>>(currencies, HttpStatus.OK);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Currency> registerChange(@RequestBody ChangeDTO change) {
        try {
            Currency _currency = currencyRepository
                    .save(new Currency(change.getName(), change.getIsoCode()));
            return new ResponseEntity<>(_currency, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Currency> updateChange(@PathVariable("id") Integer id, @RequestBody() ChangeDTO change) {
        try {
            logger.info("Buscando por {}", id);
            Optional<Currency> tutorialData = currencyRepository.findById(id);
            if (tutorialData.isPresent()) {
                Currency _currency = tutorialData.get();
                _currency.setName(change.getName());
                _currency.setIsoCode(change.getIsoCode());
                return new ResponseEntity<Currency>(currencyRepository.save(_currency), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
