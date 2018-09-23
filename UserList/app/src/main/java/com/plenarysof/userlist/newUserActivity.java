package com.plenarysof.userlist;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.net.URL;

public class newUserActivity extends AppCompatActivity {

    ImageView ivUserImageReview;
    EditText etName, etMobile;
    Button btnAddPhoto, btnSubmit;
    Uri imageURL;

    private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        initView();
        initLisntener();
        initSaveUser();
    }

    private void initView() {
        ivUserImageReview = findViewById(R.id.iv_user_image_preview);
        etName = findViewById(R.id.et_name);
        etMobile = findViewById(R.id.et_mobile);
        btnAddPhoto = findViewById(R.id.btn_add_photo);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    private void initLisntener() {
        btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oenGallery();
            }
        });
    }

    private void oenGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageURL = data.getData();
            ivUserImageReview.setImageURI(imageURL);
        }
    }

    private void initSaveUser() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(newUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
