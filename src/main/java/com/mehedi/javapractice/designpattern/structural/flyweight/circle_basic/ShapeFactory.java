package com.mehedi.javapractice.designpattern.structural.flyweight.circle_basic;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private final Map<String, Shape> shapes = new HashMap<>();

    public Shape getCircle(String color) {
        Shape circle = shapes.get(color);

        if (circle == null) {
            circle = new Circle(color);
            shapes.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }
}
