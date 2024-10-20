package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple.strategies;

public class PayByPayPal implements PaymentStrategy {
    private String email;

    public PayByPayPal(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing bank transfer of $" + amount);
    }
}
