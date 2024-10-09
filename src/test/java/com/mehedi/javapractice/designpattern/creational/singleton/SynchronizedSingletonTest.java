package com.mehedi.javapractice.designpattern.creational.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SynchronizedSingletonTest {

    @Test
    public void testSingletonInstance() {
        SynchronizedSingleton instance1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton instance2 = SynchronizedSingleton.getInstance();
        Assertions.assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    public void testMultithreadSingleton() throws InterruptedException {
        SynchronizedSingleton[] instances = new SynchronizedSingleton[2];

        Thread t1 = new Thread(() -> instances[0] = SynchronizedSingleton.getInstance());
        Thread t2 = new Thread(() -> instances[1] = SynchronizedSingleton.getInstance());

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        Assertions.assertSame(instances[0], instances[1], "Both threads should have the same singleton instance");
    }

    @Test
    public void testPerformanceOverhead() throws InterruptedException {
        int threadCount = 10000;
        Thread[] threads = new Thread[threadCount];
        long startTime = System.currentTimeMillis();

        // slight delay to ensure threads start around the same time
        Thread.sleep(100);

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                SynchronizedSingleton instance = SynchronizedSingleton.getInstance();
            });
            threads[i].start();
        }

        for(Thread thread: threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Total duration: " + duration + " ms");
        Assertions.assertTrue(duration < 5000, "Accessing the singleton should not take excessive time.");
    }
}
