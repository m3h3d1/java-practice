package com.mehedi.javapractice.mutithreading.pong_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Paddle {
    public static final int HEIGHT = 50; // Paddle size
    public static final int WIDTH = 10;
    private static final int DELTA = HEIGHT / 2; // Move size
    private static final int BORDER = 20;
    private int gameAreaHeight;
    private int locationX, locationY;
    private PongFrame frame;

    Paddle(PongFrame f) {
        this.frame = f;
        gameAreaHeight = f.getHeight() - BORDER;
        locationX = f.getWidth() - WIDTH;
        locationY = gameAreaHeight / 2;
    }
    public void resetLocation() {
        gameAreaHeight = frame.getHeight() - BORDER;
        locationX = frame.getWidth() - WIDTH;
    }
    public int getX() { return locationX; }
    public int getY() {  return locationY; }
    public void moveUp() {
        if (locationY > BORDER)
            locationY -= DELTA;
    }
    public void moveDown() {
        if (locationY + HEIGHT < gameAreaHeight + BORDER)
            locationY += DELTA;
    }
}
class Ball extends Thread {
    public static final int SIZE = 10;
    private PongFrame frame;
    private int topWall, bottomWall, leftWall, rightWall; // Boundaries
    private int locationX, locationY; // Current location of the ball
    private int directionX = 1, directionY = 1; // x- and y-direction (1 or -1)
    private Toolkit kit = Toolkit.getDefaultToolkit(); // For beep() method

    Ball(PongFrame f) {
        frame = f;
        locationX = 50;
        locationY = 50;
    }
    public int getX() { return locationX; }
    public int getY() { return locationY; }
    public void move() {
        rightWall = frame.getWidth() - SIZE; // Define bouncing region
        leftWall = 0;
        topWall = 20; // And location of walls
        bottomWall = frame.getHeight() - SIZE;
        locationX += directionX;
        locationY += directionY;
        if (frame.ballHitsPaddle()) {
            directionX = -1; // move toward left wall
            kit.beep();
        } // if ball hits paddle
        if (locationX <= leftWall) {
            directionX = +1; // move toward right wall
            kit.beep();
        } // if ball hits left wall
        if (locationY + SIZE >= bottomWall || locationY <= topWall) {
            directionY = -directionY; // reverse direction
            kit.beep();
        } // if ball hits top or bottom walls
        if (locationX >= rightWall + SIZE) {
            locationX = leftWall + 1; // jump back to left wall
        } // if ball goes through right wall
    }
    public void run() {
        while(true) {
            move();
            frame.repaint();
            try {
                sleep(10);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class PongFrame extends JFrame implements KeyListener {
    private Ball ball;
    private Paddle pad;

    public PongFrame() {
        setTitle("Pong Game");
        setBackground(Color.white);
        addKeyListener(this);
        pad = new Paddle(this);
        ball = new Ball(this);
        ball.start();
    }
    // paint() method is never called directly. Rather, it is called automatically
    // after the constructor method PongFrame(), when the program is started.
    // It is then invoked indirectly by the program by calling the repaint() method
    public void paint(Graphics g) {
        g.setColor(getBackground()); // Erase the drawing area
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.blue); // Paint the ball
        g.fillOval(ball.getX(), ball.getY(), ball.SIZE, ball.SIZE);
        pad.resetLocation(); // Paint the paddle
        g.setColor(Color.red);
        g.fillRect(pad.getX(), pad.getY(), Paddle.WIDTH, Paddle.HEIGHT);
    }
    public boolean ballHitsPaddle() {
        return ball.getX() + Ball.SIZE >= pad.getX()
                && ball.getY() >= pad.getY()
                && ball.getY() <= pad.getY() + Paddle.HEIGHT;
    }
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == e.VK_UP) {
            pad.moveUp();
        } else if(keyCode == e.VK_DOWN) {
            pad.moveDown();
        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        PongFrame frame = new PongFrame();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}