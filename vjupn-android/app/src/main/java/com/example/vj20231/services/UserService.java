package com.example.vj20231.services;

import com.example.vj20231.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @GET("users")
    Call<List<User>> getAllUser(@Query("page") int page);

    @GET("users/{id}")
    Call<User> findUser(@Path("id") int id);

    @POST("users")
    Call<User> create(@Body User user);

    @PUT("users/{id}")
    Call<User> update(@Path("id") int id, @Body User user);

    @DELETE("users/{id}")
    Call<Void> delete(@Path("id") int id);
}


