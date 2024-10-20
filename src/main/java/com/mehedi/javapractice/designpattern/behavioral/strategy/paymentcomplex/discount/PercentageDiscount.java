package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.discount;

public class PercentageDiscount implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - percentage / 100);
    }
}
