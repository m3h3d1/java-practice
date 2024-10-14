package com.mehedi.javapractice.designpattern.structural.flyweight.colorbox;

import java.util.Vector;

class ThreadPool {
    private Vector<ColorBox> boxes = new Vector<>();
    private int pause;

    class HandlerThread extends Thread {
        public void run() {
            while (true) {
                ((ColorBox) boxes.elementAt(
                        (int) (Math.random() * 1000) % boxes.size())).changeColor();
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    public ThreadPool(int p) {
        pause = p;
    }

    public void register(ColorBox r) {
        boxes.addElement(r);
    }

    public void start() {
        int NUM_THREADS = 8;
        for (int i = 0; i < NUM_THREADS; i++) {
            new HandlerThread().start();
        }
    }
}
