package com.plenarysoft.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();


    }

    private void initViews() {
        etHeight = findViewById(R.id.et_height);
        etWeight = findViewById(R.id.et_weight);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    private void initListeners() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (etHeight.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please give enter your height", Toast.LENGTH_SHORT).show();
                } else if (etWeight.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please give enter your weight", Toast.LENGTH_SHORT).show();
                } else {

                    Double result, height, weight;
                    height = Double.valueOf(etHeight.getText().toString());
                    weight = Double.valueOf(etWeight.getText().toString());

                    result = ((weight / height) * 703);

                    if (result > 0) {
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                        intent.putExtra("secret", result);

                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Please give valid information", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}
