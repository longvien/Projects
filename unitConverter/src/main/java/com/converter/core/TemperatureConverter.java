package com.converter.core;

import com.converter.Convert;

public class TemperatureConverter implements Convert {
    private String userChoice1;
    private String userChoice2;
    private double value;

    public TemperatureConverter(String u1, String u2, double inVal){
        this.userChoice1 = u1;
        this.userChoice2 = u2;
        this.value = inVal;
    }

    @Override
    public double convert() {
        double result = 0.0d;
        if (userChoice1.equals("Celsius °C") && userChoice2.equals("Fahrenheit °F")) {
            result = CtoF(this.value);
        }
        else if (userChoice1.equals("Fahrenheit °F") && userChoice2.equals("Celsius °C")) {
            result = FtoC(this.value);
        }
        else if (userChoice1.equals("Celsius °C") && userChoice2.equals("Kelvin K")) {
            result = CtoK(this.value);
        }
        else if (userChoice1.equals("Kelvin K") && userChoice2.equals("Celsius °C")) {
            result = KtoC(this.value);
        }
        else if (userChoice1.equals("Fahrenheit °F") && userChoice2.equals("Kelvin K")) {
            double valueC = FtoC(this.value);
            result = CtoK(valueC);
        }
        else if (userChoice1.equals("Kelvin K") && userChoice2.equals("Fahrenheit °F")) {
            double valueC = KtoC(this.value);
            result = CtoF(valueC);
        }
        return result;
    }

    public double CtoF(double value) { return value * (9.0/5.0) + 32;}
    public double FtoC(double value) { return (value - 32) * 5/9; }
    public double CtoK(double value) { return value + 273.15; }
    public double KtoC(double value) { return value - 273.15; }
}
