package com.mehedi.javapractice.designpattern.structural.flyweight.circle_basic;

public class FlyweightDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape redCircle = shapeFactory.getCircle("Red");
        redCircle.draw(10, 20);

        Shape greenCircle = shapeFactory.getCircle("Green");
        greenCircle.draw(30, 40);

        Shape anotherRedCircle = shapeFactory.getCircle("Red");
        anotherRedCircle.draw(50, 60);

        // Checking if the same instance is used for the same color
        System.out.println("Are both red circles the same instance? " + (redCircle == anotherRedCircle));
    }
}
