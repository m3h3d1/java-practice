package com.mehedi.javapractice.designpattern.structural.adapter;

/**
 * SquarePegs are not compatible with RoundHoles (they were implemented by
 * a previous development team). But we have to integrate them into our program.
 */
public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        return width * width;
    }
}
