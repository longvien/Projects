package com.converter.core;
import com.converter.Convert;

public class DataSizeConverter implements Convert {
    private final int depIndex;
    private final int desIndex;
    private final double inputValue;

    public DataSizeConverter(int depI, int desI, double inputValue){
        this.depIndex = depI;
        this.desIndex = desI;
        this.inputValue = inputValue;
    }

    @Override
    public double convert(){
        double destinationValue = 0;
        if (depIndex == 0 && desIndex == 1) {
            destinationValue = this.inputValue / 8;
        }
        else if (depIndex == 1 && desIndex == 0) {
            destinationValue = this.inputValue * 8;
        }
        else if (depIndex >=1 && desIndex == 0) {
            destinationValue = this.inputValue * 8 * Math.pow(1024, depIndex - 1);
        }
        else if (desIndex >= 1 && depIndex == 0) {
            destinationValue = this.inputValue / 8 * Math.pow(1024, -(desIndex -1));
        }
        else if (depIndex > desIndex) {
            destinationValue = this.inputValue * Math.pow(1024, depIndex - desIndex);
        }
        else if (depIndex < desIndex) {
            destinationValue = this.inputValue * Math.pow(1024, -(desIndex - depIndex));
        }
        else {
            destinationValue = this.inputValue;
        }
        return destinationValue;
    }

    public static DataSizeConverter getDataSizeConverter(String dep, String des, double inputVal) {
        String[] dataType = {"bit (b)", "byte (B)", "kilobyte (KB)", "megabyte (MB)", "gigabyte (GB)", "terabyte (TB)"};
        int depI = 0;
        int desI = 0;
        for (int i = 0; i < dataType.length; i++) {
            if (dataType[i].equals(dep)) {
                depI = i;
            }
            if (dataType[i].equals(des)) {
                desI = i;
            }
        }
        return new DataSizeConverter(depI, desI, inputVal);
    }
}