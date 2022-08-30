package com.example.calculatorbearyfulll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Double result = 0.0;
    private TextView textResult;
    private boolean clean = false;
    private char operation = ' ';
    private boolean calculate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.textResult);
    }

    public void catchNumber(View view) {
        if (clean) {
            textResult.setText("0");
            clean = false;
        }

        Button number = (Button) view;
        Double r = Double.parseDouble(textResult.getText().toString() + number.getText());
        textResult.setText(String.valueOf(r.intValue()));
    }

    public void operationCalculate(View view) {
        if (!calculate) {
            calculate(view);
        }

        Button button = (Button) view;
        operation = button.getText().charAt(0);
        result = Double.parseDouble(textResult.getText().toString());
        clean = true;
        calculate = false;
    }

    public void deleteNumber(View view) {
        result = 0.0;
        textResult.setText("0");
        clean = false;
        operation = ' ';
        calculate = true;
    }

    public void calculate(View view) {
        Double n = Double.parseDouble(textResult.getText().toString());

        switch (operation) {
            case '+':
                result += n;
                break;
            case '-':
                result -= n;
                break;
            case '*':
                result *= n;
                break;
            case '/':
                result /= n;
                break;
        }

        String numberFormated = String.format("%.2f", result);
        textResult.setText(numberFormated);
    }
}