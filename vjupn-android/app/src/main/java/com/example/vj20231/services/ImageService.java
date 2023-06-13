package com.example.vj20231.services;

import com.example.vj20231.entities.ImageRequest;
import com.example.vj20231.entities.ImageResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ImageService {

    @POST("image")
    Call<ImageResult> convert(@Body ImageRequest request);

}
