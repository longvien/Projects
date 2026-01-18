package com.geometry.triangle;
import com.geometry.Geometry;

public class Triangle implements Geometry {
    private double height;
    private double c;
    private double a;
    private double b;

    public Triangle(double height, double base) {
        this.height = height;
        this.c = base;
    }

    public Triangle(double side1, double side2, double base) {
        if (side1 <= 0 || side2 <= 0 || base <= 0) {
            throw new IllegalArgumentException("A side of a Triangle can't be less than or equals 0");
        }
        else if (side1 + side2 <= base || side1 + base <= side2 || side2 + base <= side1) {
            throw new IllegalArgumentException("The three values provided aren't able to be the sides of a Triangle.");
        }
        this.a = side1;
        this.b = side2;
        this.c = base;
    }

    @Override
    public double area() {
        return height * c / 2;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    public double areaByThreeSides() {
        return Math.sqrt((a + b + c) * (a + b - c) * (a - b + c) * (b + c - a)) / 4;
    }
}
