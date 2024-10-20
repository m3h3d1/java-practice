package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
    }

    public static double convert(double amount, String fromCurrency, String toCurrency) {
        if(!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Unsupported currency: " + fromCurrency + " or " + toCurrency);
        }
        double amountInUsd = amount / exchangeRates.get(fromCurrency);
        return amountInUsd * exchangeRates.get(toCurrency);
    }
}
