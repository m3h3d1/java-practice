package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies;

import java.util.concurrent.CompletableFuture;

public interface PaymentStrategy {
    CompletableFuture<Boolean> pay(double amount, String currency);
}
