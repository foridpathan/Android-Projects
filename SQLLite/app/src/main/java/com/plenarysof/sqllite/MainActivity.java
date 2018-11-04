package com.plenarysof.sqllite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.DBHelper;
public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone;
    private Button btnSubmit, btnShowContact;
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;
    String nameHolder, emailHolder, phoneHolder;
    boolean emtyTextHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initListener();

    }

    /**
     * INITIALIZE XML VIEW
     */

    private void initView() {
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        btnSubmit = findViewById(R.id.btn_submit);
        btnShowContact = findViewById(R.id.btn_show_contact);
        dbHelper = new DBHelper(this);
    }

    /**
     * ON LICK LISTENER
     */
    private void initListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEditText();
                saveToDB();
            }
        });

        /**
         * SHOW CONTACT
         */
        btnShowContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFunction();
            }
        });
    }


    private void saveToDB() {
        if (emtyTextHolder) {
            sqLiteDatabase = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DBHelper.CULMN_NAME, etName.getText().toString());
            values.put(DBHelper.CULMN_EMAIL, etEmail.getText().toString());
            values.put(DBHelper.CULMN_PHONE, etPhone.getText().toString());

            long newRow = sqLiteDatabase.insert(DBHelper.TABLE_NAME, null, values);
            Toast.makeText(this, "The Row" + newRow, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Save Date", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoginFunction() {

        sqLiteDatabase = dbHelper.getReadableDatabase();

        String[] clumn = {DBHelper.CULMN_NAME, DBHelper.CULMN_EMAIL, DBHelper.CULMN_PHONE};


        cursor = sqLiteDatabase.query(DBHelper.TABLE_NAME, clumn, null, null, null, null, null);

        Toast.makeText(this, "Save Data " + cursor.getCount(), Toast.LENGTH_SHORT).show();
    }

    private void checkEditText() {
        nameHolder = etName.getText().toString();
        emailHolder = etEmail.getText().toString();
        phoneHolder = etPhone.getText().toString();

        if (TextUtils.isEmpty(nameHolder) || TextUtils.isEmpty(emailHolder) || TextUtils.isEmpty(phoneHolder)) {
            emtyTextHolder = false;
        } else {
            emtyTextHolder = true;
        }
    }
}
