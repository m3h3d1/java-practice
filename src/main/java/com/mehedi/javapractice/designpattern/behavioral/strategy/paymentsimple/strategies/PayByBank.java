package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple.strategies;

public class PayByBank implements PaymentStrategy {
    private String bankAccount;

    public PayByBank(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing bank transfer of $" + amount);
    }
}
