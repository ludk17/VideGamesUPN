package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vj20231.adapters.NameAdapter;
import com.example.vj20231.entities.User;
import com.example.vj20231.services.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        RecyclerView rvLista =  findViewById(R.id.rvListaSimple);
        rvLista.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<List<User>> call = service.getAllUser();
        Call<User> call1 = service.findUser(1);


        User u = new User();
        u.name = "Otro Gato";
        Call<Void> call2 = service.create(u);


        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()) {
                    List<User> users = response.body();
                    NameAdapter adapter = new NameAdapter(users);
                    rvLista.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });





    }


    private List<String> data() {
        List<String> names = new ArrayList<>();
        names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");
        names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");
        names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");
        names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");
        names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");








        return names;

    }
}