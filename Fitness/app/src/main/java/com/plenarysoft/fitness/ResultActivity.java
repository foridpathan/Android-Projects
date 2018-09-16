package com.plenarysoft.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult;
    ImageView ivImage;
    Button btnTry;

    double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initViews();
        initFitnessCheck();
        initLitsteners();
    }

    private void initViews() {
        tvResult = findViewById(R.id.tv_result);
        ivImage = findViewById(R.id.iv_image);
        btnTry = findViewById(R.id.btn_try);
    }

    private void initFitnessCheck() {
        result = getIntent().getDoubleExtra("secret", 0);

        if (result > 0) {
            if (result > 18) {
                tvResult.setText("Your BMI is: " + result);
                ivImage.setImageDrawable(getResources().getDrawable(R.drawable.man_helth));
            } else {
                tvResult.setText("Your BMI is: " + result);
                ivImage.setImageDrawable(getResources().getDrawable(R.drawable.unhalthy));
            }
        } else {
            Toast.makeText(this, "Technical ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    private void initLitsteners() {
        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
