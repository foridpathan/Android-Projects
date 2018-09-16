package com.plenarysoft.nodepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowNoteActivity extends AppCompatActivity {

    TextView tvShowNote;
    Button btnAddMore;
    String key = "note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        initView();
        initViewData();
        initiListeners();

    }

    private void initView() {
        tvShowNote = findViewById(R.id.tv_show_note);
        btnAddMore = findViewById(R.id.btn_add_more);
    }

    private void initViewData() {
        String viewNote = AppPreference.getInstance(getApplicationContext()).getString(key);
        tvShowNote.setText(viewNote);
    }

    private void initiListeners () {
        btnAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowNoteActivity.this, MainActivity.class));
                finish();
            }
        });
    }

}
