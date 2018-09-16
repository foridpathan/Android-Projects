package com.plenarysoft.nodepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etWrite;
    Button btnNewNote, btnShowNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListeners();
    }

    private void initView() {
        etWrite = findViewById(R.id.et_write);
        btnNewNote = findViewById(R.id.btn_new_note);
        btnShowNote = findViewById(R.id.btn_view_note);
    }

    private void initListeners() {
        btnNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNote = etWrite.getText().toString();
                String key = "note";

                AppPreference.getInstance(getApplicationContext()).setString(key, newNote);

                etWrite.setText("");
                Toast.makeText(MainActivity.this, "Your data save successfully !", Toast.LENGTH_SHORT).show();
            }
        });

        btnShowNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowNoteActivity.class);
                startActivity(intent);
            }
        });
    }
}
