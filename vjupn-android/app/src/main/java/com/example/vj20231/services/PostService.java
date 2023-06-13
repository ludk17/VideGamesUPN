package com.example.vj20231.services;

import com.example.vj20231.entities.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostService {
    @GET("posts")
    Call<List<Post>> getAll();

    @POST("posts")
    Call<Post> create(@Body Post post);
}
