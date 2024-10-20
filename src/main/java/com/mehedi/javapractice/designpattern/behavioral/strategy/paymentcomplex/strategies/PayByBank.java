package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies;

import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils.CurrencyConverter;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils.TransactionValidator;

import java.util.concurrent.CompletableFuture;

public class PayByBank implements PaymentStrategy {
    private String bankAccount;

    public PayByBank(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public CompletableFuture<Boolean> pay(double amount, String currency) {
        return CompletableFuture.supplyAsync(() -> {
            double convertedAmount = CurrencyConverter.convert(amount, currency, "EUR");
            System.out.println("Processing bank transfer of " + convertedAmount + " EUR");

            TransactionValidator.verify(bankAccount, convertedAmount);
            simulateProcessing();
            System.out.println("Bank transfer of " + convertedAmount + " EUR was successful.");
            return true;
        });
    }

    private void simulateProcessing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
