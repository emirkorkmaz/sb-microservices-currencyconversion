package com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.entity;

import java.math.BigDecimal;

public class CurrencyExchangeDetail {

    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionRate;
    private int port;

    public CurrencyExchangeDetail() {
    }

    public CurrencyExchangeDetail(Long id, String fromCurrency, String toCurrency, BigDecimal conversionRate, int port) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
