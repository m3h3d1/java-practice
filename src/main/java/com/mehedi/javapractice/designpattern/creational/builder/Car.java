package com.mehedi.javapractice.designpattern.creational.builder;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private boolean isElectric;

    private Car(CarBuilder buider) {
        this.make = buider.make;
        this.model = buider.model;
        this.year = buider.year;
        this.color = buider.color;
        this.isElectric = buider.isElectric;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public boolean isElectric() {
        return isElectric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }

    public static class CarBuilder {
        private String make;
        private String model;
        private int year = 2024;
        private String color = "White";
        private boolean isElectric = false;

        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }
        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }
        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }
        public CarBuilder setIsElectric(boolean isElectric) {
            this.isElectric = isElectric;
            return this;
        }
        public Car build() {
            return new Car(this);
        }
    }
}
