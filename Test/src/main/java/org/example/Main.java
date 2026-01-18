package org.example;

import com.geometry.triangle.Triangle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3.0, 4.0);
        System.out.println(triangle1.area());
    }
}