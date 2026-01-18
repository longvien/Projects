package com.geometry.quadrilateral;

import com.geometry.Geometry;
public class Square implements Geometry {
    private double side;

    public Square(double side){
        this.side = side;
    }
    @Override
    public double area() {
        return Math.pow(this.side, 2);
    }
    @Override
    public double perimeter() {
        return this.side * 4;
    }
}
