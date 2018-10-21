package com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.entity;

import java.math.BigDecimal;

public class CurrencyConversionDetail {

    /**
     * {
     * id: 10002,
     * from: "EUR",
     * to: "INR",
     * conversionMultiple: 75,
     * quantity: 10000,
     * totalCalculatedAmount: 750000,
     * port: 8000,
     * }
     */

    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionRate;
    private BigDecimal originalAmount;
    private BigDecimal convertedAmount;
    private int port;

    public CurrencyConversionDetail() {
    }

    public CurrencyConversionDetail(Long id, String fromCurrency, String toCurrency, BigDecimal conversionRate,
                                    BigDecimal originalAmount, BigDecimal convertedAmount, int port) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
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

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
