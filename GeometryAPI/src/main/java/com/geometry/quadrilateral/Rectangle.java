package com.geometry.quadrilateral;

import com.geometry.Geometry;

public class Rectangle implements Geometry {
    private double width;
    private double length;

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    @Override
    public double area() {
        return this.width * this.length;
    }

    @Override
    public double perimeter(){ return (this.width + this.length) * 2; }

}
