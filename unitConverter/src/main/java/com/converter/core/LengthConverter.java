package com.converter.core;
import com.converter.Convert;

public class LengthConverter implements Convert {
    private final int userChoice1Index;
    private final int userChoice2Index;
    private final double inputValue;


    public LengthConverter(int userChoice1Index, int userChoice2Index, double inputValue) {
        this.userChoice1Index = userChoice1Index;
        this.userChoice2Index = userChoice2Index;
        this.inputValue = inputValue;
    }

    @Override
    public double convert() {
        double destinationValue = 0;
        if (userChoice1Index > userChoice2Index) {
           int subtract = userChoice1Index - userChoice2Index;
           double a = Math.pow(10, -subtract);
           destinationValue = this.inputValue * a;
        }
        else if (userChoice2Index > userChoice1Index) {
            int subtract = userChoice2Index - userChoice1Index;
            double a = Math.pow(10, subtract);
            destinationValue = this.inputValue * a;
        }
        else {
            destinationValue = this.inputValue;
        }
        return destinationValue;
    }

    public static LengthConverter getLengthConverter(String userChoice1, String userChoice2, double inputValue) {
        String[] unitLength = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
        int userChoice1Index = 0;
        int userChoice2Index = 0;
        for (int i = unitLength.length - 1; i >= 0; i--) {
            if (unitLength[i].equals(userChoice1)) {
                userChoice1Index = i;
            }
            if (unitLength[i].equals(userChoice2)) {
                userChoice2Index = i;
            }
        }
        return new LengthConverter(userChoice1Index, userChoice2Index, inputValue);
    }
}
