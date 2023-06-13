package com.example.vj20231.services;

import com.example.vj20231.entities.Comment;
import com.example.vj20231.entities.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CommentService {
    @GET("comments")
    Call<List<Comment>> getAll();

    @POST("comments")
    Call<Comment> create(@Body Comment comment);
}
