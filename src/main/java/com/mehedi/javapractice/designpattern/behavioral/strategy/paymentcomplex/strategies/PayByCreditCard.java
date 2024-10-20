package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies;

import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils.CurrencyConverter;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils.TransactionValidator;

import java.util.concurrent.CompletableFuture;

public class PayByCreditCard implements PaymentStrategy {
    private final String cardNumber;
    private final String cardHolderName;
    private final String cvv;

    public PayByCreditCard(String cardNumber, String cardHolderName, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
    }

    @Override
    public CompletableFuture<Boolean> pay(double amount, String currency) {
        return CompletableFuture.supplyAsync(() -> {
            double convertedAmount = CurrencyConverter.convert(amount, currency, "USD");
            System.out.println("Processing Credit Card payment of " + convertedAmount + " USD");

            TransactionValidator.verify(cardNumber, convertedAmount);
            simulateProcessing();
            System.out.println("Credit Card payment of " + convertedAmount + " USD was successful.");
            return true;
        });
    }

    private void simulateProcessing() {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
