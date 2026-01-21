package com.geometry.circle;

public class Circle {
    private double radius;
    private final static double pi = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() { return Math.pow(radius, 2) * pi; }
}
