package com.plenarysof.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class activity_add_user extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etAddress, etOccupation, etEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

    }

    private void initView() {
        setContentView(R.layout.activity_add_user);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etAddress = findViewById(R.id.et_address);
        etOccupation = findViewById(R.id.et_occupatin);
        etEducation = findViewById(R.id.et_education);
    }
}
