package mutithreading.random_dot;

import javax.swing.*;
import java.awt.*;

class Dotty {
    // Coordinates
    private static final int HREF = 20, VREF = 20, LEN = 200;
    private JPanel canvas;
    private int nDots; // Number of dots drawn
    private int firstRed = 0; // Number of the first red dot

    public Dotty(JPanel canv) {
        canvas = canv;
    }

    public void draw() {
        int width = 5; // Dot size
        int height = 5;
        nDots = 0;
        Graphics g = canvas.getGraphics();
        int k = 0;
        long bound = 1000000000; // # of iterations
        while (k < bound) {
            int x = HREF + (int) (Math.random() * LEN);
            int y = VREF + (int) (Math.random() * LEN);
            if (k % 1000000 == 0) { // Every millionth iteration
                g.fillOval(x, y, width, height); // Draw a dot
                nDots++;
                if ((Math.random() < 0.05) && (firstRed == 0)) {
                    g.setColor(Color.red); // Change color to red
                    firstRed = nDots;
                }
            }
            k++;
        }
    }

    public void clear() { // Clear screen and report result
        Graphics g = canvas.getGraphics();
        g.setColor(canvas.getBackground());
        g.fillRect(HREF, VREF, LEN + 3, LEN + 3);
        System.out.println(
                "Number of dots drawn since first red = " + (nDots - firstRed));
    }
}
