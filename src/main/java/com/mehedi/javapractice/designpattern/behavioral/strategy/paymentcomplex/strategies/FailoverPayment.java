package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies;

import java.util.concurrent.CompletableFuture;

public class FailoverPayment implements PaymentStrategy {
    private final PaymentStrategy primary;
    private final PaymentStrategy secondary;

    public FailoverPayment(PaymentStrategy primary, PaymentStrategy secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    @Override
    public CompletableFuture<Boolean> pay(double amount, String currency) {
        return primary.pay(amount, currency)
                .thenCompose(success -> {
                    if (success) {
                        return CompletableFuture.completedFuture(true);
                    } else {
                        System.out.println("Primary payment method failed. Trying secondary.");
                        return secondary.pay(amount, currency);
                    }
                });
    }
}
