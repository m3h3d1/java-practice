package com.mehedi.javapractice.designpattern.structural.flyweight.circle_basic;

public class Circle implements Shape {
    private final String color;  // Intrinsic state

    public Circle(String color) {
        this.color = color;  // Color is intrinsic and shared
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " circle at (" + x + ", " + y + ")");
    }
}
