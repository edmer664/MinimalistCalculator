package com.edmer.calculator;

import android.util.Log;

public class Calculator {

    public String getDisplayText() {
        return displayText;
    }

    public double getCurrentNumber() {
        return currentNumber;
    }

    public double getPreviousNumber() {
        return previousNumber;
    }

    public char getOperator() {
        return operator;
    }

    private String displayText;
    private double currentNumber;
    private double previousNumber;
    private char operator;
    private RefreshCallback callback;

    public void setCallback(RefreshCallback callback) {
        this.callback = callback;
    }
    public Calculator() {
        this.displayText = "0";
        this.currentNumber = 0;
        this.previousNumber = 0;
        this.operator = ' ';
    }

    public void logValues(){
        Log.i("Calculator", "Display Text: " + displayText);
        Log.i("Calculator", "Current Number: " + currentNumber);
        Log.i("Calculator", "Previous Number: " + previousNumber);
        Log.i("Calculator", "Operator: " + operator);
    }
    public void numberButtonPress(char digit){
        if(displayText.equals("0") || displayText.equals("Error")){
            displayText = "" + digit;
        } else {
            displayText += digit;
        }
        if (callback != null) {
            callback.refreshValues();
            logValues();
        }
        currentNumber = Double.parseDouble(displayText);

    }

    public void operationButtonPress(char operation){
        if(previousNumber != 0){
            calculate();
        } else {
            previousNumber = currentNumber;
            currentNumber = 0;
            displayText = "0";
            operator = operation;
        }
        if (callback != null) {
            callback.refreshValues();
            logValues();
        }
    }

    public void calculate(){
        switch(operator){
            case '+':
                currentNumber = previousNumber + currentNumber;
                break;
            case '-':
                currentNumber = previousNumber - currentNumber;
                break;
            case '*':
                currentNumber = previousNumber * currentNumber;
                break;
            case '/':
                if(currentNumber == 0){
                    displayText = "Error";
                    return;
                }
                currentNumber = previousNumber / currentNumber;
                break;
            default:
                return;
        }
        // round to 2 decimal places
        currentNumber = Math.round(currentNumber * 100.0) / 100.0;
        previousNumber = 0;
        operator = ' ';
        displayText = "" + currentNumber;
        if (callback != null) {
            callback.refreshValues();
            logValues();
        }
    }

    public void clear(){
        displayText = "0";
        currentNumber = 0;
        previousNumber = 0;
        operator = ' ';
        if (callback != null) {
            callback.refreshValues();
            logValues();
        }
    }

    public void backspace(){
        if(displayText.length() > 1){
            displayText = displayText.substring(0, displayText.length() - 1);
            currentNumber = Double.parseDouble(displayText);
        } else {
            displayText = "0";
            currentNumber = 0;
        }
        if (callback != null) {
            callback.refreshValues();
            logValues();
        }
    }
}
