package com.iandsilvas.bcpquiz.repository;

import com.iandsilvas.bcpquiz.domain.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyChangeRepository extends JpaRepository<CurrencyExchange, Integer> {
}
