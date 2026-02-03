package com.converter.core;

import com.converter.Convert;

public class WeightConverter implements Convert{
    private final int userChoice1Index;
    private final int userChoice2Index;
    private final double inputValue;

    public WeightConverter(int userChoice1Index, int userChoice2Index, double inputValue) {
        this.userChoice1Index = userChoice1Index;
        this.userChoice2Index = userChoice2Index;
        this.inputValue = inputValue;
    }
    @Override
    public double convert() {
        double destinationValue = 0;
        if (userChoice1Index < 2 && userChoice2Index >= 2) {
            int subtract = userChoice2Index - userChoice1Index;
            double a = Math.pow(10, subtract + 1);
            destinationValue = inputValue * a;
        }
        else if (userChoice1Index >= 2 && userChoice2Index < 2) {
            int subtract = userChoice1Index - userChoice2Index;
            double a = Math.pow(10, -subtract - 1);
            destinationValue = inputValue * a;
        }
        else if (userChoice1Index > userChoice2Index) {
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

    public static WeightConverter getWeightConverter(String userChoice1, String userChoice2, double inputValue) {
        String[] unitWeight = {"ton", "quintal", "kilogram", "hectogram", "decagram", "gram", "decigram", "centigram", "milligram"};
        int userChoice1Index = 0;
        int userChoice2Index = 0;
        for (int i = 0; i < unitWeight.length; i++) {
            if (unitWeight[i].equals(userChoice1)) {
                userChoice1Index = i;
            }
            if (unitWeight[i].equals(userChoice2)) {
                userChoice2Index = i;
            }
        }
    return new WeightConverter(userChoice1Index, userChoice2Index, inputValue);
    }
}
