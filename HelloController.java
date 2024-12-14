package com.sayhello.javafxtutorial;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

public class HelloController {
//    @FXML
//    private Label welcomeText;

    @FXML
    private TextField mainTextField;
    @FXML
    private TextField resultTextField;


    @FXML

    public void  handleButton(javafx.event.ActionEvent event) {
        mainTextField.setEditable(false);
        resultTextField.setEditable(false);
        resultTextField.setPromptText("Result is");
        resultTextField.setStyle("-fx-focus-color: transparent;");
        Button clicked = (Button) event.getSource();
        String buttonText = clicked.getText();

        String expression;
        if (buttonText.equals("AC")) {
            mainTextField.clear();
            resultTextField.clear();
        } else if (buttonText.equals("=")) {
            expression = mainTextField.getText();
            try {
                double result = evaluateExpression(expression);
                resultTextField.setText(String.valueOf(result));
            } catch (Exception e) {
                Label label = new Label();
                label.setText("Invalid Statement");
            }
        } else {
            mainTextField.appendText(buttonText);
        }
    }

        private double evaluateExpression (String expression) {
            String[] token = expression.split("([X/+-])");

            if (token.length != 2) throw new IllegalArgumentException("Invalid Input");

            double num1 = Double.parseDouble(token[0]);
            double num2 = Double.parseDouble(token[1]);
            char operator = expression.charAt(token[0].length());

            switch(operator){
                case  '+' : return num1 + num2;
                case  '-' : return (num1 - num2);
                case  'X' : return num1 * num2;
                case  '/' : return num1 / num2;
                default: throw new IllegalArgumentException("Invalid Operator!!");
            }

        }
        }