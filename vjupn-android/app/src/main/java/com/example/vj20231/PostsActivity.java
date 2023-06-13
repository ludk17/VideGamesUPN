package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.vj20231.adapters.PostAdapter;
import com.example.vj20231.entities.Post;
import com.example.vj20231.entities.User;
import com.example.vj20231.services.PostService;
import com.example.vj20231.services.UserService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);


        RecyclerView rvLista =  findViewById(R.id.rvPosts);
        rvLista.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://647742fc9233e82dd53b49b7.mockapi.io/") // revisar
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        PostService service = retrofit.create(PostService.class);
        Call<List<Post>> call = service.getAll();


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.i("MAIN_APP", String.valueOf(response.code()));
                if(response.isSuccessful()) {
                    PostAdapter adapter = new PostAdapter(response.body());
                    rvLista.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }
}