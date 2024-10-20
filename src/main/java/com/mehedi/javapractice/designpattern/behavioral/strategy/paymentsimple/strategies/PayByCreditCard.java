package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple.strategies;

public class PayByCreditCard implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;

    public PayByCreditCard(String cardNumber, String cardHolderName, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
