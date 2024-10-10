package com.mehedi.javapractice.designpattern.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarBuilderTest {
    @Test
    public void testCarBuilderWithAllAttributes() {
        Car car = new Car.CarBuilder()
                .setMake("Tesla")
                .setModel("Model S")
                .setYear(2022)
                .setColor("Red")
                .setIsElectric(true)
                .build();

        assertEquals("Tesla", car.getMake());
        assertEquals("Model S", car.getModel());
        assertEquals(2022, car.getYear());
        assertEquals("Red", car.getColor());
        assertTrue(car.isElectric());
    }

    @Test
    public void testCarBuilderWithPartialAttributes() {
        Car car = new Car.CarBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .build(); // Only make and model are set

        assertEquals("Honda", car.getMake());
        assertEquals("Civic", car.getModel());
        assertEquals(2024, car.getYear());
        assertEquals("White", car.getColor());
        assertFalse(car.isElectric());
    }
}
