package com.foridmac.variable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Double firstNumber, secoundNumber, result;
    String oparetor;
    TextView tvEquation, tvResult;
    Button btn9, btn8, btn7, btn6, btn5, btn4, btn3, btn2, btn1,btn0, btnPlus, btnMinus, btnMultiplication, btnDivision, btnDot,btnEquation, btnClc, btnDel, btnMod, btnMemory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEquation = findViewById(R.id.tv_equation);
        tvResult = findViewById(R.id.tv_result);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_zero);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiplication = findViewById(R.id.btn_multiplication);
        btnDivision = findViewById(R.id.btn_division);
        btnEquation = findViewById(R.id.btn_equal);
        btnDot = findViewById(R.id.btn_dot);
        btnClc = findViewById(R.id.btn_clc);
        btnDel = findViewById(R.id.btn_del);
        btnMod = findViewById(R.id.btn_mod);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = tvEquation.getText() + btn1.getText().toString();
                tvEquation.setText(num1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num2 = tvEquation.getText() + btn2.getText().toString();
                tvEquation.setText(num2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num3 = tvEquation.getText() + btn3.getText().toString();
                tvEquation.setText(num3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num4 = tvEquation.getText() + btn4.getText().toString();
                tvEquation.setText(num4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num5 = tvEquation.getText() + btn5.getText().toString();
                tvEquation.setText(num5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num6 = tvEquation.getText() + btn6.getText().toString();
                tvEquation.setText(num6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num7 = tvEquation.getText() + btn7.getText().toString();
                tvEquation.setText(num7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num8 = tvEquation.getText() + btn8.getText().toString();
                tvEquation.setText(num8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num9 = tvEquation.getText() + btn9.getText().toString();
                tvEquation.setText(num9);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num0 = tvEquation.getText() + btn0.getText().toString();
                tvEquation.setText(num0);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               firstNumber = Double.parseDouble(tvEquation.getText().toString());
               tvEquation.setText("");
                oparetor = "+";
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(tvEquation.getText().toString());
                tvEquation.setText("");
                oparetor = "-";
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(tvEquation.getText().toString());
                tvEquation.setText("");
                oparetor = "*";
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(tvEquation.getText().toString());
                tvEquation.setText("");
                oparetor = "/";
            }
        });

        btnClc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEquation.setText("");
                tvResult.setText("");
            }
        });

        btnEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer;
                secoundNumber = Double.parseDouble(tvEquation.getText().toString());
                if (oparetor == "+") {
                    result = firstNumber + secoundNumber;
                    answer = String.format("%.0f", result);
                    tvResult.setText(answer);
                } else if (oparetor == "-") {
                    result = firstNumber - secoundNumber;
                    answer = String.format("%.0f", result);
                    tvResult.setText(answer);
                } else if (oparetor == "*") {
                    result = firstNumber * secoundNumber;
                    answer = String.format("%.0f", result);
                    tvResult.setText(answer);
                } else if (oparetor == "/") {
                    result = firstNumber / secoundNumber;
                    answer = String.format("%.0f", result);
                    tvResult.setText(answer);
                }
            }
        });


    }
}
