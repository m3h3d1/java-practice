package com.mehedi.javapractice.designpattern.structural.adapter;

/**
 * Adapter allows fitting square pegs into round holes.
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        double diagonal = squarePeg.getWidth() * Math.sqrt(2);
        return diagonal / 2;
    }
}
