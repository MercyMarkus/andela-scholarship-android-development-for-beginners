package com.mercy.markus.javadevelopersongithub.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mesy on 24/08/17.
 */

public class ApiClient {

    private static final String BASE_URL = "https://api.github.com";

    private Retrofit retrofit;

    public ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ApiResponse getService() {
        return retrofit.create(ApiResponse.class);
    }
}
