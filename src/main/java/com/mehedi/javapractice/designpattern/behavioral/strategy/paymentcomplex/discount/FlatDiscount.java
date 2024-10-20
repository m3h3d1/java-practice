package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.discount;

public class FlatDiscount implements DiscountStrategy {
    private final double discountAmount;

    public FlatDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double amount) {
        return Math.max(0, amount - discountAmount);
    }
}
