package com.example.assignment04;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label billCalc;
    @FXML
    private TextField food;
    @FXML
    private TextField drink;
    @FXML
    private TextField dessert;
    @FXML
    private RadioButton t1;
    @FXML
    private RadioButton t2;
    @FXML
    private RadioButton t3;
    @FXML
    private Label summary;

    @FXML
    public void submit (){
        try {
            String foodF = food.getText();
            double fD = Double.parseDouble(foodF);

            String drinkF = drink.getText();
            double drD = Double.parseDouble(drinkF);

            String dessertF = dessert.getText();
            double desD = Double.parseDouble(dessertF);

            double mealPrice = fD + drD + desD;
            double taxPrice = mealPrice * .1;
            double tip =0;
            if(t1.isSelected()){
                tip = (mealPrice + taxPrice) * .15;
            } else if (t2.isSelected()) {
                tip = (mealPrice + taxPrice) * .20;
            }else if (t3.isSelected()) {
                tip = (mealPrice + taxPrice) * .25;
            }
            double total = mealPrice + taxPrice + tip;

           summary.setText("                 Summary"+ "\n\nMeal Price:                     $"+String.format("%.2f", mealPrice)+ "\nTax Price:                        $"+String.format("%.2f", taxPrice)+ "\nTip Price:                        $"+String.format("%.2f",tip)+ "\n\nTotal Price:                     $"+String.format("%.2f",total));
            food.setDisable(true);
            drink.setDisable(true);
            dessert.setDisable(true);
            t1.setDisable(true);
            t2.setDisable(true);
            t3.setDisable(true);

        } catch (Exception e){
            summary.setText("Enter digits only!\n\n" + "Example: 10.5 instead of $10.5\n\n"+ "Enter 0 if no price available");
        }
    }
    @FXML
    public void reset(){
        food.setDisable(false);
        drink.setDisable(false);
        dessert.setDisable(false);
        t1.setDisable(false);
        t2.setDisable(false);
        t3.setDisable(false);
        food.setText("");
        drink.setText("");
        dessert.setText("");
        summary.setText("");
        t1.setSelected(true);
    }
}