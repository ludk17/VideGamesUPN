package com.example.vj20231;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

import com.example.vj20231.adapters.NameAdapter;
import com.example.vj20231.db.AppDatabase;
import com.example.vj20231.entities.User;
import com.example.vj20231.repositories.UserRepository;
import com.example.vj20231.services.UserService;
import com.example.vj20231.utils.RetrofitBuilder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaActivity extends AppCompatActivity {

    Retrofit mRetrofit;
    RecyclerView mRvLista;
    SearchView mSvFilter;
    boolean mIsLoading = false;
    int mPage = 1;
    String currentFilter = "";
    List<User> mdata = new ArrayList<>();
    NameAdapter mAdapter = new NameAdapter(mdata);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        mRetrofit = RetrofitBuilder.build();
        mSvFilter = findViewById(R.id.svFilter);
        currentFilter = mSvFilter.getQuery().toString();

        mSvFilter.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("MAIN_APP query", query);
                mdata.clear();
                mAdapter.notifyDataSetChanged();
                currentFilter = query;
                loadMore(currentFilter, 1);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(Objects.equals(newText, "")) {
                    mdata.clear();
                    mAdapter.notifyDataSetChanged();
                    currentFilter = "";
                    loadMore(currentFilter, 1);
                }
                return true;
            }


        });








        Log.i("MAIN_APP CurrentFilter", currentFilter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRvLista =  findViewById(R.id.rvListaSimple);
        mRvLista.setLayoutManager(layoutManager);
        mRvLista.setAdapter(mAdapter);

        mRvLista.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!mIsLoading) {

                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == mdata.size() - 1) {
                        mPage++;
                        loadMore(currentFilter, mPage);
                    }
                }

            }
        });



        if(!isNetworkConnected()) {
            AppDatabase db = AppDatabase.getInstance(this);
            UserRepository repository = db.userRepository();
            List<User> users = repository.getAllUser();
            Log.i("MAIN_APP: DB", new Gson().toJson(users));
        }
        else {
//            uploadToWebService();
            loadMore(currentFilter, mPage);
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void uploadToWebService() {
        // retrofit
    }


    private void loadMore(String filter, int nextPage) {
        mIsLoading = true;

        mdata.add(null);
        mAdapter.notifyItemInserted(mdata.size() - 1);

        UserService service = mRetrofit.create(UserService.class);
        Log.i("MAIN_APP  Page:", String.valueOf(nextPage));
        service.getAllUser(filter, 6, nextPage).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(mdata.size() > 0) {
                    mdata.remove(mdata.size() - 1);
                    mAdapter.notifyItemRemoved(mdata.size() - 1);
                }

                mdata.addAll(response.body());
                mAdapter.notifyDataSetChanged();
                mIsLoading = false;
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