package com.converter;
import com.converter.core.LengthConverter;
// import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        //lengthConverter();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Unit Converter Programme");
        //Menu
        Menu m = new Menu("Menu");
        MenuItem m1 = new MenuItem("Length Converter");
        MenuItem m2 = new MenuItem("Weight Converter");
        m.getItems().addAll(m1, m2);
        MenuBar mb = new MenuBar();
        mb.getMenus().add(m);

        // Length Converter
        Label labelL = new Label("Value to convert:");
        TextField textFieldL = new TextField();
        String[] unitLength = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
        var comboBoxL1 = new ComboBox(FXCollections.observableArrayList(unitLength));
        Label labelL2 = new Label(" = ");
        Label resultLabelL = new Label();
        var comboBoxL2 = new ComboBox(FXCollections.observableArrayList(unitLength));
        Button buttonL = new Button("Convert");
        //button.setStyle("-fx-background-color: #FF0000;"); set button red.

        buttonL.setOnAction(e -> {
            String value = textFieldL.getText();
            double inputValue = Double.parseDouble(value);
            String userChoice1 = String.valueOf(comboBoxL1.getValue());
            String userChoice2 = String.valueOf(comboBoxL2.getValue());
            LengthConverter user = getLengthConverter(userChoice1, userChoice2, inputValue);
            resultLabelL.setText(String.valueOf(user.convert()));
        });

        HBox layoutL = new HBox(labelL, textFieldL, comboBoxL1, labelL2, resultLabelL, comboBoxL2, buttonL);
        BorderPane root = new BorderPane();
        root.setTop(mb);
        root.setCenter(layoutL);


        // Weight Converter
        Label labelW = new Label("Value to convert:");
        TextField textFieldW = new TextField();
        String[] unitWeight = {"ton", "quintal", "dam", "m", "dm", "cm", "mm"};
        var comboBoxW1 = new ComboBox(FXCollections.observableArrayList(unitWeight));
        Label labelW2 = new Label(" = ");
        Label resultLabelW = new Label();
        var comboBoxW2 = new ComboBox(FXCollections.observableArrayList(unitWeight));
        Button buttonW = new Button("Convert");

        HBox layoutW = new HBox(labelW, textFieldW, comboBoxW1, labelW2, resultLabelW, comboBoxW2, buttonW);
        root.setTop(mb);
        root.setCenter(layoutW);

        Scene scene = new Scene(root, 1000, 400);
        stage.setScene(scene);
        stage.show();

        m1.setOnAction(e -> root.setCenter(layoutL));
        m2.setOnAction(e -> root.setCenter(layoutW));
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