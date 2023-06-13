package com.example.vj20231;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vj20231.utils.CamaraUtils;

public class FormUserActivity extends AppCompatActivity {


    private ImageView ivAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        ivAvatar = findViewById(R.id.ivAvatar);
        Button btnCamera = findViewById(R.id.btnOpenCamera);
        Button btnGallery = findViewById(R.id.btnGallery);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CamaraUtils.setUpOpenCamera(FormUserActivity.this);

            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CamaraUtils.setUpOpenGallery(FormUserActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK) return;
        Bitmap photo = CamaraUtils.GetBitMap(this, requestCode, data);
        ivAvatar.setImageBitmap(photo);

    }



}