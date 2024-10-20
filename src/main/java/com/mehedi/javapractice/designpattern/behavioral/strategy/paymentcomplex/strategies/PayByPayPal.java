package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies;

import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils.CurrencyConverter;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils.TransactionValidator;

import java.util.concurrent.CompletableFuture;

public class PayByPayPal implements PaymentStrategy {
    private final String email;

    public PayByPayPal(String email) {
        this.email = email;
    }

    @Override
    public CompletableFuture<Boolean> pay(double amount, String currency) {
        return CompletableFuture.supplyAsync(() -> {
            double convertedAmount = CurrencyConverter.convert(amount, currency, "USD");
            System.out.println("Processing PayPal payment of " + convertedAmount + " USD");

            TransactionValidator.verify(email, convertedAmount);
            simulateProcessing();
            System.out.println("PayPal payment of " + convertedAmount + " USD was successful.");
            return true;
        });
    }

    private void simulateProcessing() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
