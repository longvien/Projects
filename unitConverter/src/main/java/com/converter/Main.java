package com.converter;
import com.converter.core.LengthConverter;
// import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        //lengthConverter();
    }

    @Override
    public void start(Stage stage) {
        Label label = new Label("Value to convert:");
        TextField textField = new TextField();
        String[] unitLength = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
        var comboBox = new ComboBox(FXCollections.observableArrayList(unitLength));
        Label label1 = new Label(" = ");
        Label resultLabel = new Label();
        var comboBox2 = new ComboBox(FXCollections.observableArrayList(unitLength));
        Button button = new Button("Convert");
        //button.setStyle("-fx-background-color: #FF0000;"); set button red.


        button.setOnAction(e -> {
            String value = textField.getText();
            double inputValue = Double.parseDouble(value);
            String userChoice1 = String.valueOf(comboBox.getValue());
            String userChoice2 = String.valueOf(comboBox2.getValue());
            LengthConverter user = getLengthConverter(userChoice1, userChoice2, inputValue);
            resultLabel.setText(String.valueOf(user.convert()));
        });

        HBox layout = new HBox(30); // spacing = 10px
        layout.getChildren().addAll(label, textField, comboBox, label1, resultLabel, comboBox2, button);

        Scene scene = new Scene(layout, 900, 300);

        stage.setTitle("Unit Converter Programme");
        stage.setScene(scene);
        stage.show();
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

/*public static void lengthConverter() {
        Scanner user1 = new Scanner(System.in);
        System.out.println("Please enter the input unit");
        String userChoice1 = user1.nextLine().trim();
        System.out.println("Please enter the output unit");
        String userChoice2 = user1.nextLine().trim();
        System.out.println("Please enter the input Value");
        double inputValue = Double.parseDouble(user1.nextLine().trim());
        LengthConverter user = getLengthConverter(userChoice1, userChoice2, inputValue);
        System.out.println(inputValue + userChoice1 + " to " + userChoice2 + " is " + user.convert() + userChoice2);
    } */