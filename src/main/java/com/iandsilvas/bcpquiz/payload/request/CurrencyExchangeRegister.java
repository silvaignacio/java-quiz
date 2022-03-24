package com.iandsilvas.bcpquiz.payload.request;

import java.math.BigDecimal;

public class CurrencyExchangeRegister {
    private Integer fromCurrency;
    private Integer toCurrency;
    private BigDecimal value;

    public Integer getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Integer fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Integer getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Integer toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
