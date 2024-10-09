package com.mehedi.javapractice.designpattern.creational.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BillPughSingletonTest {

    @Test
    public void testReflection() throws Exception {
        // Get the singleton instance
        BillPughSingleton instance1 = BillPughSingleton.getInstance();

        // Get the private constructor of the BillPughSingleton class
        Constructor<BillPughSingleton> constructor = BillPughSingleton.class.getDeclaredConstructor();

        // Set accessible to true to bypass private constructor
        constructor.setAccessible(true);

        // Check that an InvocationTargetException wraps a RuntimeException when reflection tries to create another instance
        InvocationTargetException exception = Assertions.assertThrows(InvocationTargetException.class, () -> {
            BillPughSingleton instance2 = constructor.newInstance();
        });

        // Check if the cause of InvocationTargetException is a RuntimeException
        Assertions.assertTrue(exception.getCause() instanceof RuntimeException,
                "The cause should be a RuntimeException");
    }

    @Test
    public void testPerformanceOverhead() throws InterruptedException {
        int threadCount = 10000;
        Thread[] threads = new Thread[threadCount];
        long startTime = System.currentTimeMillis();
        Thread.sleep(100);

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                BillPughSingleton instance = BillPughSingleton.getInstance();
            });
            threads[i].start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Total duration: " + elapsedTime + " ms");
        Assertions.assertTrue(elapsedTime < 5000, "Accessing the singleton should not take excessive time.");
    }
}
