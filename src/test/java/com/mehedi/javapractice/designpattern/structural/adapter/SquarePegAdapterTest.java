package com.mehedi.javapractice.designpattern.structural.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquarePegAdapterTest {
    @Test
    void testSmallSquarePegFits() {
        RoundHole hole = new RoundHole(5);
        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePegAdapter adapter = new SquarePegAdapter(smallSqPeg);
        assertTrue(hole.fits(adapter), "Square peg w2 should fit round hole r5.");
    }

    @Test
    void testLargeSquarePegDoesNotFit() {
        RoundHole hole = new RoundHole(5);
        SquarePeg largeSqPeg = new SquarePeg(20);
        SquarePegAdapter adapter = new SquarePegAdapter(largeSqPeg);
        assertFalse(hole.fits(adapter), "Square peg w20 should not fit round hole r5.");
    }
}
