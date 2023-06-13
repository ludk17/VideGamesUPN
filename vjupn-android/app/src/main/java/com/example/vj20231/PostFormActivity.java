package com.example.vj20231;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vj20231.entities.ImageRequest;
import com.example.vj20231.entities.ImageResult;
import com.example.vj20231.entities.Post;
import com.example.vj20231.services.ImageService;
import com.example.vj20231.services.PostService;
import com.example.vj20231.utils.CamaraUtils;

import java.io.ByteArrayOutputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostFormActivity extends AppCompatActivity {

    private static final int OPEN_CAMERA_REQUEST = 1001;
    private static final int OPEN_GALLERY_REQUEST = 1002;
    private ImageView ivFormPost;
    private String imgURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_form);

        ivFormPost = findViewById(R.id.ivFormPost);
        Button btnCamera = findViewById(R.id.btnOpenCamera);
        Button btnGallery = findViewById(R.id.btnGallery);
        Button btnSave = findViewById(R.id.btnSave);

        btnCamera.setOnClickListener(view -> CamaraUtils.setUpOpenCamera(PostFormActivity.this));
        btnGallery.setOnClickListener(view -> CamaraUtils.setUpOpenGallery(PostFormActivity.this));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // llamar a retrofit
                EditText etDescription = findViewById(R.id.etDescription);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://647742fc9233e82dd53b49b7.mockapi.io/") // revisar
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                PostService service = retrofit.create(PostService.class);

                Post post = new Post();
                post.description = etDescription.getText().toString();
                post.imageURL = imgURL;

                Call<Post> call = service.create(post);

                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Log.i("MAIN_APP",  String.valueOf(response.code()));
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK) return;
        Bitmap photo = CamaraUtils.GetBitMap(this, requestCode, data);
        ivFormPost.setImageBitmap(photo);


//
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        photo.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//        byte[] byteArray = byteArrayOutputStream .toByteArray();
//
//        String imgBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://demo-upn.bit2bittest.com/") // revisar
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ImageService service = retrofit.create(ImageService.class);
//
//        ImageRequest req = new ImageRequest();
//        req.base64Image = imgBase64;
//
//        Call<ImageResult> call = service.convert(req);
//        call.enqueue(new Callback<ImageResult>() {
//            @Override
//            public void onResponse(Call<ImageResult> call, Response<ImageResult> response) {
//                if(response.isSuccessful()) {
//                    imgURL = response.body().url;
//                    Log.i("MAIN_APP", imgURL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ImageResult> call, Throwable t) {
//
//            }
//        });


    }
}