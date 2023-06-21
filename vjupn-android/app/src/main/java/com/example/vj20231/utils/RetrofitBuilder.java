package com.example.vj20231.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    public static Retrofit build() {
        return new Retrofit.Builder()
        .baseUrl("https://647742fc9233e82dd53b49b7.mockapi.io/") // revisar
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }

}
