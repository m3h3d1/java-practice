package com.mehedi.javapractice.networking;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class Timer implements Runnable {
    private SlideShowFrame frame;
    public Timer(SlideShowFrame app) {
        frame = app;
    }
    public void run() {
        try {
            while(true) {
                frame.nextSlide();
                Thread.sleep( 1000 );
            }
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
class SlideShowFrame extends JFrame {
    public static final int WIDTH=300, HEIGHT=200;
    private static final int NIMGS = 4;
    private Image[] slide = new Image[NIMGS];
    private Image currentImage = null;
    private int nextImg = 0;
    private String baseURL = "https://raw.githubusercontent.com/ram8647/javajavajava/master/classroom-resources/labs/ch09/slideshow/demo/";

    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (currentImage != null)
            g.drawImage(currentImage, 10, 10, this);
    }
    public void nextSlide() {
        currentImage = slide[nextImg];
        nextImg = (nextImg + 1) % NIMGS;
        repaint();
    }
    public SlideShowFrame() {
        for (int k=0; k < NIMGS; k++) {
            try {
                slide[k] = ImageIO.read( new URL(baseURL +  "demo" + k + ".gif"));
            }
            catch (MalformedURLException e) {
                System.out.println( "Malformed URL: " + e) ;
            }
            catch (IOException e) {
                System.out.println("I/O Exception " + e);
            }
        }
        Thread timer = new Thread(new Timer(this));
        timer.start();
        setSize( WIDTH, HEIGHT );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

public class SlideShow {
    public static void main(String[] args) {
        SlideShowFrame s = new SlideShowFrame();
    }
}
