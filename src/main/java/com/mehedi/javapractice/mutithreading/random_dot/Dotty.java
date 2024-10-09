package com.mehedi.javapractice.mutithreading.random_dot;

import javax.swing.*;
import java.awt.*;

class Dotty implements Runnable {
    // Coordinates
    private static final int HREF = 20, VREF = 20, LEN = 200;
    private JPanel canvas;
    private int nDots; // Number of dots to draw
    private int nDrawn; // Number of dots drawn
    private int firstRed = 0; // Number of the first red dot
    private boolean isCleared = false; // Panel is cleared

    public void run() {
        draw();
    }

    public Dotty(JPanel canv, int dots) {
        canvas = canv;
        nDots = dots;
    }

    public void draw() {
        int width = 5; // Dot size
        int height = 5;
        Graphics g = canvas.getGraphics();
        for(nDrawn = 0; !isCleared && nDrawn < nDots; nDrawn++) {
            int x = HREF + (int) (Math.random() * LEN);
            int y = VREF + (int) (Math.random() * LEN);
            g.fillOval(x, y, width, height); // Draw a dot
            if ((Math.random() < 0.05) && (firstRed == 0)) {
                g.setColor(Color.red); // Change color to red
                firstRed = nDrawn;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void clear() { // Clear screen and report result
        isCleared = true;
        Graphics g = canvas.getGraphics();
        g.setColor(canvas.getBackground());
        g.fillRect(HREF, VREF, LEN + 3, LEN + 3);
        System.out.println(
                "Number of dots drawn since first red = " + (nDrawn - firstRed));
    }
}
