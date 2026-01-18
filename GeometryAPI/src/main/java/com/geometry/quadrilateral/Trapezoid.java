package com.geometry.quadrilateral;
import com.geometry.Geometry;

public class Trapezoid implements Geometry{
    private double lbase;
    private double sbase;
    private double height;
    private double side1;
    private double side2;

    public Trapezoid(double lbase, double sbase) {
        this.lbase = lbase;
        this.sbase = sbase;
    }
    public Trapezoid(double lbase1, double sbase1, double height){
        this(lbase1, sbase1);
        this.height = height;
    }

    public Trapezoid(double side1, double side2, double lbase2, double sbase2){
        this(lbase2, sbase2);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double area(){
        return ((lbase + sbase) * height) / 2;
    }
    @Override
    public double perimeter() {return lbase + sbase + side1 + side2; }

}
