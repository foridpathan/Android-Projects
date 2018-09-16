package com.plenarysoft.disissionmacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgGender;
    RadioButton rbMale, rbFemale, rbOthers;
    CheckBox cbJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGender = findViewById(R.id.rg_gender);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        rbOthers = findViewById(R.id.rb_others);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_male) {
                    Toast.makeText(getApplicationContext(), "Male Checked", Toast.LENGTH_LONG).show();
                } else if (checkedId == R.id.rb_female) {
                    Toast.makeText(getApplicationContext(), "Female Checked", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Others Checked", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
