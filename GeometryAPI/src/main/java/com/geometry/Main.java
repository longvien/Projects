package com.geometry;
import com.geometry.circle.Circle;
import com.geometry.quadrilateral.Parallelogram;
import com.geometry.quadrilateral.Rectangle;
import com.geometry.quadrilateral.Square;
import com.geometry.quadrilateral.Trapezoid;
import com.geometry.triangle.Triangle;

public class Main {
    public static void main(String[] args) {
        //rectangleArea
        Rectangle rectangle1 = new Rectangle(5.0, 7.0);
        System.out.println(rectangle1.area());

        //triangleArea
        Triangle triangle1 = new Triangle(5.0, 4.0);
        double area = triangle1.area();
        System.out.println(area);

        //exceptionHandlingTriangle
        System.out.println("Triangle area calculating depends on 3 sides ");
        try {
        Triangle triangle2 = new Triangle(1, 9, 7);
        System.out.println(triangle2.areaByThreeSides());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        //squareAreaAndPerimeter
        System.out.println("Square area calculation:");
        Square square1 = new Square(5);
        System.out.println(square1.area());
        System.out.println("Square perimeter calculation");
        System.out.println(square1.perimeter());

        //parallelogramArea
        System.out.println("Parallelogram area calculation");
        Parallelogram parallelogram1 = new Parallelogram(4.0, 5.0);
        System.out.println(parallelogram1.area());

        //trapezoidPerimeter
        System.out.println("Trapezoid perimeter calculation");
        Trapezoid trapezoid1 = new Trapezoid(8.0, 4.0, 5.0, 7.0);
        System.out.println(trapezoid1.perimeter());

        //circleArea
        System.out.println("Circle area calculation");
        Circle circle = new Circle(3.0);
        System.out.println(circle.area());
    }
}