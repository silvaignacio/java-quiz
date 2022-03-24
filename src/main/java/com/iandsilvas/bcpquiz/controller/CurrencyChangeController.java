package com.iandsilvas.bcpquiz.controller;

import com.iandsilvas.bcpquiz.domain.Currency;
import com.iandsilvas.bcpquiz.domain.CurrencyExchange;
import com.iandsilvas.bcpquiz.payload.request.CurrencyExchangeRegister;
import com.iandsilvas.bcpquiz.repository.CurrencyChangeRepository;
import com.iandsilvas.bcpquiz.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/exchange")
public class CurrencyChangeController {

    Logger logger = LoggerFactory.getLogger(CurrencyChangeController.class);


    @Autowired
    private CurrencyChangeRepository currencyChangeRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CurrencyExchange> registerChange(@RequestBody CurrencyExchangeRegister currencyRegister) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        try {
            Optional<Currency> fromCurrency = currencyRepository.findById(currencyRegister.getFromCurrency());
            Optional<Currency> toCurrency = currencyRepository.findById(currencyRegister.getToCurrency());
            if (fromCurrency.isPresent() && toCurrency.isPresent()) {
                CurrencyExchange _exchange =
                        currencyChangeRepository.save(new CurrencyExchange(fromCurrency.get(),
                                toCurrency.get(), new Date(), currencyRegister.getValue(), username));
                return new ResponseEntity<>(_exchange, HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
