package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple;

import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple.strategies.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if(paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        paymentStrategy.pay(amount);
    }
}
