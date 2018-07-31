package com.plenarysoft.EngineeringCalculetor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    TextView tvEsprestion, tvResult;
    Button btnNine, btnEight, btnSeven, btnSix, btnFive, btnFour, btnThree, btnTwo, btnOne, btnZero, btnPlus, btnMinus, btnDivision, btnMultiply, btnEquation, btnClr;
    Boolean isPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load Text View
        tvEsprestion = findViewById(R.id.tv_expresion);
        tvResult = findViewById(R.id.tv_result);

        // Load Button
        btnNine = findViewById(R.id.btn_nine);
        btnEight = findViewById(R.id.btn_eight);
        btnSeven = findViewById(R.id.btn_seven);
        btnSix = findViewById(R.id.btn_six);
        btnFive = findViewById(R.id.btn_five);
        btnFour = findViewById(R.id.btn_four);
        btnThree = findViewById(R.id.btn_three);
        btnTwo = findViewById(R.id.btn_two);
        btnOne = findViewById(R.id.btn_one);
        btnZero = findViewById(R.id.btn_zero);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnDivision = findViewById(R.id.btn_division);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnEquation = findViewById(R.id.btn_equal);
        btnClr = findViewById(R.id.btn_clr);


        // OnClick Expresion
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "9");
                isPress = false;
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "8");
                isPress = false;
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "7");
                isPress = false;
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "6");
                isPress = false;
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "5");
                isPress = false;
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "4");
                isPress = false;
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "3");
                isPress = false;
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "2");
                isPress = false;
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "1");
                isPress = false;
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText(tvEsprestion.getText() + "0");
                isPress = false;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPress == false) {
                    tvEsprestion.setText(tvEsprestion.getText() + "+");
                    isPress = true;
                } else {
                    return;
                }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPress == false) {
                    tvEsprestion.setText(tvEsprestion.getText() + "-");
                    isPress = true;
                } else {
                    return;
                }
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPress == false) {
                    tvEsprestion.setText(tvEsprestion.getText() + "*");
                    isPress = true;
                } else {
                    return;
                }
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPress == false) {
                    tvEsprestion.setText(tvEsprestion.getText() + "/");
                    isPress = true;
                } else {
                    return;
                }
            }
        });
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEsprestion.setText("");
            }
        });

        //EQUAL
        btnEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expresion = tvEsprestion.getText().toString();

                if (expresion.endsWith("+") || expresion.endsWith("-") || expresion.endsWith("*") || expresion.endsWith("/")) {
                    tvResult.setText("Error");
                } else {

                    Expression expression = new ExpressionBuilder(expresion).build();
                    try {
                        double result = expression.evaluate();
                        tvResult.setText(Double.toString(result));
                    } catch (ArithmeticException ex) {
                        tvResult.setText("Error");
                    }
                }
            }
        });
    }
}
