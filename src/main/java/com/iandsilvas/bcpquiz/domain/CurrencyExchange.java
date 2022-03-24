package com.iandsilvas.bcpquiz.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Currency fromCurrency;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Currency toCurrency;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name="user_updated")
    private String usernameUpdated;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Currency fromCurrency, Currency toCurrency, Date date, BigDecimal value, String usernameUpdated) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
        this.value = value;
        this.usernameUpdated = usernameUpdated;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getUsernameUpdated() {
        return usernameUpdated;
    }

    public void setUsernameUpdated(String usernameUpdated) {
        this.usernameUpdated = usernameUpdated;
    }
}
