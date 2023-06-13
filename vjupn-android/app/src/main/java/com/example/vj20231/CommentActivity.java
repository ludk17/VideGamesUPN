package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.vj20231.adapters.CommentAdapter;
import com.example.vj20231.adapters.PostAdapter;
import com.example.vj20231.entities.Comment;
import com.example.vj20231.entities.Post;
import com.example.vj20231.services.CommentService;
import com.example.vj20231.services.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        RecyclerView rvLista =  findViewById(R.id.rvComments);
        rvLista.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://647742fc9233e82dd53b49b7.mockapi.io/") // revisar
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        CommentService service = retrofit.create(CommentService.class);
        Call<List<Comment>> call = service.getAll();


        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                Log.i("MAIN_APP", String.valueOf(response.code()));
                if(response.isSuccessful()) {
                    CommentAdapter adapter = new CommentAdapter(response.body());
                    rvLista.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.i("MAIN_APP", t.toString());
            }
        });

    }
}