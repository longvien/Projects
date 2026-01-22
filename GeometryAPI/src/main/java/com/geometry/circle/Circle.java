package com.geometry.circle;
import com.geometry.Geometry;

public class Circle implements Geometry {
    private double radius;
    private double diameter = radius * 2;
    private final static double pi = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() { return Math.pow(radius, 2) * pi; }

    @Override
    public double perimeter() { return diameter * pi; }
}
