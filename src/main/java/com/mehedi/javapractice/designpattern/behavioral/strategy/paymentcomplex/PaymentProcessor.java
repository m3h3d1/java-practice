package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex;

import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.discount.DiscountStrategy;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies.PaymentStrategy;

import java.util.concurrent.CompletableFuture;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    private DiscountStrategy discountStrategy;

    // Set the payment strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Set the discount strategy at runtime
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // Checkout with the selected payment and discount strategy
    public CompletableFuture<Boolean> checkout(double amount, String currency) {
        if (discountStrategy != null) {
            amount = discountStrategy.applyDiscount(amount);
        }

        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }

        return paymentStrategy.pay(amount, currency);
    }
}
