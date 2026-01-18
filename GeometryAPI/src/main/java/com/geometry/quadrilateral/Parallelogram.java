package com.geometry.quadrilateral;
import com.geometry.Geometry;

public class Parallelogram implements Geometry{
    private double base;
    private double side;
    private double height;

    public Parallelogram(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public Parallelogram(double base, double height, double side){
            this(base, height);
            this.side = side;
    }

    @Override
    public double area() {
        return base * height;
    }

    @Override
    public double perimeter() { return 2 * (base + side);}


}
