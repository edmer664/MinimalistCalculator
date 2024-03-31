package com.edmer.calculator;

import androidx.appcompat.app.AppCompatActivity;
// text
import androidx.core.*;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calculator = new Calculator();

    String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadListeners();
    }

    private void loadListeners() {
        calculator.setCallback(new RefreshCallback() {
            @Override
            public void refreshValues() {
                TextView mainDisplay = findViewById(R.id.mainDisplay);
                mainDisplay.setText(calculator.getDisplayText());
                TextView subDisplay = findViewById(R.id.subDisplay);
                subDisplay.setText(calculator.getPreviousNumber() + " " + calculator.getOperator());
            }
        });
        findViewById(R.id.number0Button).setOnClickListener(v -> calculator.numberButtonPress('0'));
        findViewById(R.id.number1Button).setOnClickListener(v -> calculator.numberButtonPress('1'));
        findViewById(R.id.number2Button).setOnClickListener(v -> calculator.numberButtonPress('2'));
        findViewById(R.id.number3Button).setOnClickListener(v -> calculator.numberButtonPress('3'));
        findViewById(R.id.number4Button).setOnClickListener(v -> calculator.numberButtonPress('4'));
        findViewById(R.id.number5Button).setOnClickListener(v -> calculator.numberButtonPress('5'));
        findViewById(R.id.number6Button).setOnClickListener(v -> calculator.numberButtonPress('6'));
        findViewById(R.id.number7Button).setOnClickListener(v -> calculator.numberButtonPress('7'));
        findViewById(R.id.number8Button).setOnClickListener(v -> calculator.numberButtonPress('8'));
        findViewById(R.id.number9Button).setOnClickListener(v -> calculator.numberButtonPress('9'));
        findViewById(R.id.plusButton).setOnClickListener(v -> calculator.operationButtonPress('+'));
        findViewById(R.id.minusButton).setOnClickListener(v -> calculator.operationButtonPress('-'));
        findViewById(R.id.multiplyButton).setOnClickListener(v -> calculator.operationButtonPress('*'));
        findViewById(R.id.divideButton).setOnClickListener(v -> calculator.operationButtonPress('/'));
        findViewById(R.id.equalButton).setOnClickListener(v -> calculator.calculate());
        findViewById(R.id.clearButton).setOnClickListener(v -> calculator.clear());
        findViewById(R.id.backspaceButton).setOnClickListener(v -> calculator.backspace());

        // value display
        TextView mainDisplay = findViewById(R.id.mainDisplay);
        mainDisplay.setText(calculator.getDisplayText());
        TextView subDisplay = findViewById(R.id.subDisplay);
        subDisplay.setText(calculator.getPreviousNumber() + " " + calculator.getOperator());

    }

}