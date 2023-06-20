package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.vj20231.adapters.NameAdapter;
import com.example.vj20231.db.AppDatabase;
import com.example.vj20231.entities.User;
import com.example.vj20231.repositories.UserRepository;
import com.example.vj20231.services.UserService;
import com.google.gson.Gson;

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


        AppDatabase db = AppDatabase.getInstance(this);

        UserRepository repository = db.userRepository();

        List<User> users = repository.getAllUser();

//        User user = new User();
//        user.id = 1;
//        user.name = "Luigi";
//        user.username = "luigi";
//        user.email = "luigi.mendoza@gmail.com";
//
//        repository.create(user);



        Log.i("MAIN_APP", new Gson().toJson(users));

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